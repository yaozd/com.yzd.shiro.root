package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbRolePermissionWhere;

import java.util.List;

public interface IRolePermissionServiceInf {
    int insertSelective(TbRolePermission record);

    TbRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRolePermission record);

    int insertList(List<TbRolePermission> pojo);

    int updateByRoleIdSelective(TbRolePermission record);

    List<TbRolePermission> selectList(TbRolePermission tableWhere, TbRolePermissionWhere extendWhere, PageWhere pageWhere);

    Long selectCount(TbPermission tableWhere, TbRolePermissionWhere extendWhere);
}