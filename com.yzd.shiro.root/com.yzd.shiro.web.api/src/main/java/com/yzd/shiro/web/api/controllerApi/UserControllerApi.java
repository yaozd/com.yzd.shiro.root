package com.yzd.shiro.web.api.controllerApi;


import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserRoleWhere;
import com.yzd.shiro.db.entity.where.TbUserWhere;
import com.yzd.shiro.service.inf.IUserRoleServiceInf;
import com.yzd.shiro.service.inf.IUserServiceInf;
import com.yzd.shiro.web.api.model.request.user.AddEditUserForm;
import com.yzd.shiro.web.api.model.request.user.GetListUserForm;
import com.yzd.shiro.web.api.model.response.user.GetListUserVM;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserControllerApi {
    @ApiOperation(value = "online-测试权限验证")
    @GetMapping("online")
    @RequiresPermissions("user:online")
    public String online() {
        return "user:online";
    }

    @ApiOperation(value = "view-测试登录认证")
    @GetMapping("view")
    @RequiresAuthentication //登录权限
    public String view() {
        return "user:view";
    }

    @ApiOperation(value = "create-测试无权访问权限")
    @GetMapping("create")
    @RequiresPermissions("user:create")
    public String create() {
        return "user:create";
    }

    @Autowired
    IUserServiceInf iUserServiceInf;
    @Autowired
    IUserRoleServiceInf iUserRoleServiceInf;

    @ApiOperation(value = "getListUser-获得角色列表")
    @PostMapping("getListUser")
    public List<GetListUserVM> getListUser(@RequestBody GetListUserForm form) {
        TbUser where = GetListUserForm.toEntity(form);
        TbUserWhere extendWhere = GetListUserForm.toEntity4Where(form);
        List<TbUser> itemList4TbUser = iUserServiceInf.selectList(where, extendWhere, PageWhere.newPage(0, 500));
        List<Long> where4UserId = itemList4TbUser.stream().map(TbUser::getId).distinct().collect(Collectors.toList());
        TbUserRole where4UserRole = new TbUserRole();
        where4UserRole.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        TbUserRoleWhere extendWhere4UserRole = new TbUserRoleWhere();
        extendWhere4UserRole.setUserId4InList(where4UserId);
        List<TbUserRole> itemList4TbUserRole = iUserRoleServiceInf.selectList(where4UserRole, extendWhere4UserRole, PageWhere.newPage(0, 50));
        List<GetListUserVM> itemList4GetListUerVM = new ArrayList<>();
        itemList4TbUser.forEach(item -> itemList4GetListUerVM.add(GetListUserVM.toVM(item)));
        return itemList4GetListUerVM;
    }

    @ApiOperation(value = "addEditUser-添加或编辑资源")
    @PostMapping("addEditUser")
    public String addEditUser(@RequestBody AddEditUserForm form) {
        //
        TbUser item = AddEditUserForm.toEntity(form);
        if (item.getId() == 0) {
            iUserServiceInf.insertSelective(item);
            return "auth:add-ok";
        }
        iUserServiceInf.updateByPrimaryKeySelective(item);
        return "auth:edit-ok";
    }
}
