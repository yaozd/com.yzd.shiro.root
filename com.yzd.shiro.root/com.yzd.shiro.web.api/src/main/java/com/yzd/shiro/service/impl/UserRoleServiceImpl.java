package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.dao.dao.TbUserRoleDao;
import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserRoleWhere;
import com.yzd.shiro.service.inf.IUserRoleServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements IUserRoleServiceInf {

    @Autowired
    private TbUserRoleDao tbUserRoleDao;

    @Override
    public int insertSelective(TbUserRole record) {
        return tbUserRoleDao.insertSelective(record);
    }

    @Override
    public TbUserRole selectByPrimaryKey(Long id) {
        return tbUserRoleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbUserRole record) {
        return tbUserRoleDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TbUserRole> selectList(TbUserRole tableWhere, TbUserRoleWhere extendWhere, PageWhere pageWhere) {
        return tbUserRoleDao.selectList(tableWhere, extendWhere, pageWhere);
    }

    @Override
    public Long selectCount(TbUserRole tableWhere, TbUserRoleWhere extendWhere) {
        return tbUserRoleDao.selectCount(tableWhere, extendWhere);
    }
}
