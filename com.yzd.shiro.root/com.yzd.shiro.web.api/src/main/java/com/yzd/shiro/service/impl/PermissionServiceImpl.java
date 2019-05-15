package com.yzd.shiro.service.impl;

import com.yzd.shiro.db.dao.dao.TbPermissionDao;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;
import com.yzd.shiro.service.inf.IPermissionServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionServiceInf
{
    @Autowired
    TbPermissionDao tbPermissionDao;
    @Override
    public int insertSelective(TbPermission record) {
        return tbPermissionDao.insertSelective(record);
    }

    @Override
    public TbPermission selectByPrimaryKey(Long id) {
        return tbPermissionDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(TbPermission record) {
        return tbPermissionDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TbPermission> selectList(TbPermission tableWhere, TbPermissionWhere extendWhere, PageWhere pageWhere) {
        return tbPermissionDao.selectList(tableWhere, extendWhere, pageWhere);
    }

    @Override
    public Long selectCount(TbPermission tableWhere, TbPermissionWhere extendWhere) {
        return tbPermissionDao.selectCount(tableWhere, extendWhere);
    }
}
