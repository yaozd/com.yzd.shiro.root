package com.yzd.shiro.db.dao.dao;

import com.yzd.shiro.db.dao.mapper.TbUserRoleMapper;
import com.yzd.shiro.db.entity.table.TbUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
