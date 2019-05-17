package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.dao.dao.TbRoleDao;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;
import com.yzd.shiro.db.entity.where.TbRoleWhere;
import com.yzd.shiro.service.inf.IRoleServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<TbRole> selectList(TbRole tableWhere, TbRoleWhere extendWhere, PageWhere pageWhere) {
        return tbRoleDao.selectList(tableWhere, extendWhere, pageWhere);
    }

    @Override
    public Long selectCount(TbPermission tableWhere, TbPermissionWhere extendWhere) {
        return tbRoleDao.selectCount(tableWhere, extendWhere);
    }
}
