package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.dao.dao.TbRoleDao;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.service.inf.IRoleServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleServiceInf {
    @Autowired
    TbRoleDao tbRoleDao;
    @Override
    public int insertSelective(TbRole record) {
        return tbRoleDao.insertSelective(record);
    }

    @Override
    public TbRole selectByPrimaryKey(Long id) {
        return tbRoleDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbRole record) {
        return tbRoleDao.updateByPrimaryKeySelective(record);
    }
}
