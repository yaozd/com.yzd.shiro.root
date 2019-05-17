package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbRolePermission;

import java.util.List;

public interface IRolePermissionServiceInf {
    int insertSelective(TbRolePermission record);

    TbRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRolePermission record);

    int insertList(List<TbRolePermission> pojo);

    int updateByRoleIdSelective(TbRolePermission record);
}