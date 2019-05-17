package com.yzd.shiro.db.dao.dao;

import com.yzd.shiro.db.dao.mapper.TbRoleMapper;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;
import com.yzd.shiro.db.entity.where.TbRoleWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbRoleDao {
    @Autowired
    TbRoleMapper tbRoleMapper;

    public int insertSelective(TbRole record) {
        return tbRoleMapper.insertSelective(record);
    }


    public TbRole selectByPrimaryKey(Long id) {
        return tbRoleMapper.selectByPrimaryKey(id);
    }


    public int updateByPrimaryKeySelective(TbRole record) {
        return tbRoleMapper.updateByPrimaryKeySelective(record);
    }

    public List<TbRole> selectList(TbRole tableWhere, TbRoleWhere extendWhere, PageWhere pageWhere) {
        return tbRoleMapper.selectList(tableWhere, extendWhere, pageWhere);
    }

    public Long selectCount(TbPermission tableWhere, TbPermissionWhere extendWhere) {
        return tbRoleMapper.selectCount(tableWhere, extendWhere);
    }
}
