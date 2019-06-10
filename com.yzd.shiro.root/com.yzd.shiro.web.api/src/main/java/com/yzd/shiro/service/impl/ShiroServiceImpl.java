package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.service.inf.IPermissionServiceInf;
import com.yzd.shiro.service.inf.IRolePermissionServiceInf;
import com.yzd.shiro.service.inf.IShiroServiceInf;
import com.yzd.shiro.service.inf.IUserRoleServiceInf;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShiroServiceImpl implements IShiroServiceInf {

    @Autowired
    IUserRoleServiceInf iUserRoleServiceInf;
    @Autowired
    IRolePermissionServiceInf iRolePermissionServiceInf;
    @Autowired
    IPermissionServiceInf iPermissionServiceInf;

    @Override
    public Set<String> findPermissionByUserId(Long userId) {
        Set<String> permissionList = new HashSet<>();
        TbUserRole where4TbUserRole = getWhere4TbUserRole(userId);
        TbUserRole item4UserRole = iUserRoleServiceInf.selectOne(where4TbUserRole, null);
        if (item4UserRole == null) {
            return permissionList;
        }
        TbRolePermission where4TbRolePermission = getWhere4TbRolePermission(item4UserRole.getRoleId());
        List<TbRolePermission> itemList4RolePermission = iRolePermissionServiceInf.selectList(where4TbRolePermission, null, PageWhere.newPage(0, 500));
        if (itemList4RolePermission.isEmpty()) {
            return permissionList;
        }
        List<Long> itemList4PermissionId = itemList4RolePermission.stream().map(TbRolePermission::getPermissionId).collect(Collectors.toList());
        List<TbPermission> itemList4Permission = getTbPermissions();
        if (itemList4Permission.isEmpty()) {
            return permissionList;
        }
        Set<String> permissionCodeList = itemList4Permission.stream()
                .filter(m -> itemList4PermissionId.contains(m.getId()) && StringUtils.isNotBlank(m.getPermissionCode()))
                .map(TbPermission::getPermissionCode).collect(Collectors.toSet());
        if (permissionCodeList == null) {
            return permissionList;
        }
        return permissionCodeList;
    }

    /**
     * 获得所有有效资源：理论上此处是有缓存的
     *
     * @return
     */
    private List<TbPermission> getTbPermissions() {
        TbPermission tableWhere = new TbPermission();
        tableWhere.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return iPermissionServiceInf.selectList(tableWhere, null, PageWhere.newPage(0, 1000));
    }

    private TbRolePermission getWhere4TbRolePermission(Long roleId) {
        TbRolePermission where = new TbRolePermission();
        where.setRoleId(roleId);
        where.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return where;
    }

    private TbUserRole getWhere4TbUserRole(Long userId) {
        TbUserRole where = new TbUserRole();
        where.setUserId(userId);
        where.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return where;
    }
}
