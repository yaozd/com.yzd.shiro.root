package com.yzd.shiro.db.dao.dao;

import com.yzd.shiro.db.dao.mapper.TbUserRoleMapper;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserRoleWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbUserRoleDao {

    @Autowired
    TbUserRoleMapper tbUserRoleMapper;

    public int insertSelective(TbUserRole record) {
        return tbUserRoleMapper.insertSelective(record);
    }

    
    public TbUserRole selectByPrimaryKey(Long id) {
        return tbUserRoleMapper.selectByPrimaryKey(id);
    }

    
    public int updateByPrimaryKeySelective(TbUserRole record) {
        return tbUserRoleMapper.updateByPrimaryKeySelective(record);
    }

   
    public List<TbUserRole> selectList(TbUserRole tableWhere, TbUserRoleWhere extendWhere, PageWhere pageWhere) {
        return tbUserRoleMapper.selectList(tableWhere, extendWhere, pageWhere);
    }

   
    public Long selectCount(TbUserRole tableWhere, TbUserRoleWhere extendWhere) {
        return tbUserRoleMapper.selectCount(tableWhere, extendWhere);
    }
}
