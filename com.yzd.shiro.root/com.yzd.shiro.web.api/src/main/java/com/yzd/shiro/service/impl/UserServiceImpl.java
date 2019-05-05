package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.dao.dao.TbUserDao;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserWhere;
import com.yzd.shiro.service.inf.IUserServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserServiceInf {

    @Autowired
    TbUserDao tbUserDao;

    @Override
    public int insertSelective(TbUser record) {
        return tbUserDao.insertSelective(record);
    }

    @Override
    public TbUser selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(TbUser record) {
        return 0;
    }

    @Override
    public List<TbUser> selectList(TbUser tableWhere, TbUserWhere extendWhere,PageWhere pageWhere) {
        return tbUserDao.selectList(tableWhere,extendWhere,pageWhere);
    }

    @Override
    public TbUser selectOne(TbUser tableWhere, TbUserWhere extendWhere) {
        return tbUserDao.selectOne(tableWhere,extendWhere);
    }
}
