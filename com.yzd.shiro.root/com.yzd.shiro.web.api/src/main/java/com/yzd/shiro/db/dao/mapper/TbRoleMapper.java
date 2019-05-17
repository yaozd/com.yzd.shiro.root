package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbRole;

public interface TbRoleMapper {
    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRole record);
}