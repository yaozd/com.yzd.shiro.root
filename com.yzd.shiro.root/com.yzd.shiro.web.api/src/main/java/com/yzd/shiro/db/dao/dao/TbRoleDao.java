package com.yzd.shiro.db.dao.dao;

import com.yzd.shiro.db.dao.mapper.TbRoleMapper;
import com.yzd.shiro.db.entity.table.TbRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TbRoleDao  {
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
}
