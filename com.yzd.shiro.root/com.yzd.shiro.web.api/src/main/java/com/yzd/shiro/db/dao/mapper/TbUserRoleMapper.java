package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbUserRole;

public interface TbUserRoleMapper {
    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUserRole record);
}