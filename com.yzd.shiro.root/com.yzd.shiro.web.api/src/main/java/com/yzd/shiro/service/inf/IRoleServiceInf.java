package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbRole;

public interface IRoleServiceInf {
    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRole record);
}
