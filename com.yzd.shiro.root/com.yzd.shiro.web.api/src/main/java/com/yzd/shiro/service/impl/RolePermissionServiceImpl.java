package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.dao.dao.TbRolePermissionDao;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbRolePermissionWhere;
import com.yzd.shiro.service.inf.IRolePermissionServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements IRolePermissionServiceInf {

    @Autowired
    TbRolePermissionDao tbRolePermissionDao;

    @Override
    public int insertSelective(TbRolePermission record) {
        return tbRolePermissionDao.insertSelective(record);
    }

    @Override
    public TbRolePermission selectByPrimaryKey(Long id) {
        return tbRolePermissionDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbRolePermission record) {
        return tbRolePermissionDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int insertList(List<TbRolePermission> pojo) {
        return tbRolePermissionDao.insertList(pojo);
    }

    @Override
    public int updateByRoleIdSelective(TbRolePermission record) {
        return tbRolePermissionDao.updateByRoleIdSelective(record);
    }

    @Override
    public List<TbRolePermission> selectList(TbRolePermission tableWhere, TbRolePermissionWhere extendWhere, PageWhere pageWhere) {
        return tbRolePermissionDao.selectList(tableWhere, extendWhere, pageWhere);
    }

    @Override
    public Long selectCount(TbPermission tableWhere, TbRolePermissionWhere extendWhere) {
        return tbRolePermissionDao.selectCount(tableWhere, extendWhere);
    }
}
