package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbUserRole;

public interface IUserRoleServiceInf {
    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUserRole record);
}
