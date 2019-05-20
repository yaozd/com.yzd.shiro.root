package com.yzd.shiro.web.api.controllerApi;
import java.util.ArrayList;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.service.inf.IRolePermissionServiceInf;
import com.yzd.shiro.service.inf.IRoleServiceInf;
import com.yzd.shiro.web.api.common.exceptionExt.CustomException;
import com.yzd.shiro.web.api.model.request.role.AddEditRoleForm;
import com.yzd.shiro.web.api.model.response.role.GetListRoleVM;
import com.yzd.shiro.web.api.model.response.role.GetRoleVM;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @ApiOperation(value = "getListRole-获得角色列表")
    @GetMapping("getListRole")
    public List<GetListRoleVM> getListRole() {
        TbRole where=new TbRole();
        where.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        List<TbRole> itemList4TbPermission = iRoleServiceInf.selectList(where, null, PageWhere.newPage(0, 500));
        List<GetListRoleVM> itemList4GetListRoleVM = new ArrayList<>();
        itemList4TbPermission.forEach(item -> itemList4GetListRoleVM.add(GetListRoleVM.toVM(item)));
        return itemList4GetListRoleVM;
    }
    @ApiOperation(value = "getRole-获得角色")
    @GetMapping("getRole")
    public GetRoleVM getRole(Long id) {
        TbRole item4Role = iRoleServiceInf.selectByPrimaryKey(id);
        if (item4Role == null) {
            throw new CustomException("没有找到id=[" + id + "]的资源");
        }
        TbRolePermission where=new TbRolePermission();
        where.setRoleId(id);
        where.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        List<TbRolePermission> itemList4RolePermission=iRolePermissionServiceInf.selectList(where, null, PageWhere.newPage(0, 500));
        return GetRoleVM.toVM(item4Role,itemList4RolePermission);
    }
    @ApiOperation(value = "delRole-删除角色")
    @PostMapping("delRole")
    public String delRole(Long id) {
        TbRole item4Role = iRoleServiceInf.selectByPrimaryKey(id);
        if (item4Role == null) {
            throw new CustomException("没有找到id=[" + id + "]的角色");
        }
        TbRole record4Role=new TbRole();
        record4Role.setId(id);
        record4Role.setGmtIsDel(TbPublicEnum.gmtIsDel.YES.CODE);
        iRoleServiceInf.updateByPrimaryKeySelective(record4Role);
        TbRolePermission record4RolePermission=new TbRolePermission();
        record4RolePermission.setRoleId(id);
        record4RolePermission.setGmtIsDel(TbPublicEnum.gmtIsDel.YES.CODE);
        iRolePermissionServiceInf.updateByRoleIdSelective(record4RolePermission);
        return "删除成功";
    }
}
