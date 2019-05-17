package com.yzd.shiro.web.api.controllerApi;

import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.service.inf.IRoleServiceInf;
import com.yzd.shiro.web.api.model.request.auth.AddEditPermForm;
import com.yzd.shiro.web.api.model.request.role.AddEditRoleForm;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleControllerApi {

    @Autowired
    IRoleServiceInf iRoleServiceInf;

    @ApiOperation(value = "addEditPerm-添加或编辑角色")
    @PostMapping("addEditPerm")
    public String addEditRole(@RequestBody AddEditRoleForm form) {
        //
        TbRole item = AddEditRoleForm.toEntity(form);
        if(item.getId()==0){
            iRoleServiceInf.insertSelective(item);
            return "role:add-ok";
        }
        iRoleServiceInf.updateByPrimaryKeySelective(item);
        return "role:edit-ok";
    }
}
