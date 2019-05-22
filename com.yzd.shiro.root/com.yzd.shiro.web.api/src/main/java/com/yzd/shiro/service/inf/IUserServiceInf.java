package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserWhere;

import java.util.List;

public interface IUserServiceInf {
    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);

    List<TbUser> selectList(TbUser tableWhere, TbUserWhere extendWhere,PageWhere pageWhere);

    TbUser selectOne(TbUser tableWhere, TbUserWhere extendWhere);
}
