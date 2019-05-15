package com.yzd.shiro.db.dao.dao;

import com.yzd.shiro.db.dao.mapper.TbPermissionMapper;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbPermissionDao {
    @Autowired
    TbPermissionMapper tbPermissionMapper;

    public int insertSelective(TbPermission record) {
        return tbPermissionMapper.insertSelective(record);
    }


    public TbPermission selectByPrimaryKey(Long id) {
        return tbPermissionMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(TbPermission record) {
        return tbPermissionMapper.updateByPrimaryKeySelective(record);
    }

    public List<TbPermission> selectList(TbPermission tableWhere, TbPermissionWhere extendWhere, PageWhere pageWhere) {
        return tbPermissionMapper.selectList(tableWhere, extendWhere, pageWhere);
    }

    public Long selectCount(TbPermission tableWhere, TbPermissionWhere extendWhere) {
        return tbPermissionMapper.selectCount(tableWhere, extendWhere);
    }
}
