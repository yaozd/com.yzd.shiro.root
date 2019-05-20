package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.dao.dao.TbUserRoleDao;
import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.service.inf.IUserRoleServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
