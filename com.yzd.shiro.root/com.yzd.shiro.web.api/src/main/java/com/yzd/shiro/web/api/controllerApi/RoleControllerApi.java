package com.yzd.shiro.web.api.controllerApi;
import java.util.Date;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import com.yzd.shiro.service.inf.IRolePermissionServiceInf;
import com.yzd.shiro.service.inf.IRoleServiceInf;
import com.yzd.shiro.web.api.model.request.role.AddEditRoleForm;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleControllerApi {

    @Autowired
    IRoleServiceInf iRoleServiceInf;
    @Autowired
    IRolePermissionServiceInf iRolePermissionServiceInf;

    @ApiOperation(value = "addEditRole-添加或编辑角色")
    @PostMapping("addEditRole")
    public String addEditRole(@RequestBody AddEditRoleForm form) {
        //
        TbRole item4Role = AddEditRoleForm.toEntity(form);
        if (item4Role.getId() == 0) {
            iRoleServiceInf.insertSelective(item4Role);
            long roleId = item4Role.getId();
            List<TbRolePermission> itemList4RolePermission = AddEditRoleForm.toEntity4RolePermission(roleId, form.getPermIds());
            if(!itemList4RolePermission.isEmpty()){
                iRolePermissionServiceInf.insertList(itemList4RolePermission);
            }
            return "role:add-ok";
        }
        iRoleServiceInf.updateByPrimaryKeySelective(item4Role);
        long roleId = item4Role.getId();
        //删除旧的关联
        TbRolePermission item4RolePermissionUpdate=AddEditRoleForm.toEntity4RolePermissionUpdate(roleId);
        iRolePermissionServiceInf.updateByRoleIdSelective(item4RolePermissionUpdate);
        //插入新的关联
        List<TbRolePermission> itemList4RolePermission = AddEditRoleForm.toEntity4RolePermission(roleId, form.getPermIds());
        if(!itemList4RolePermission.isEmpty()){
            iRolePermissionServiceInf.insertList(itemList4RolePermission);
        }
        return "role:edit-ok";
    }
}
