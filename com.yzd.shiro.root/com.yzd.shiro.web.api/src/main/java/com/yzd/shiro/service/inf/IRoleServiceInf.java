package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;
import com.yzd.shiro.db.entity.where.TbRoleWhere;

import java.util.List;

public interface IRoleServiceInf {
    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRole record);

    List<TbRole> selectList(TbRole tableWhere, TbRoleWhere extendWhere, PageWhere pageWhere);

    Long selectCount(TbPermission tableWhere, TbPermissionWhere extendWhere);
}
