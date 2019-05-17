package com.yzd.shiro.db.dao.dao;

import com.yzd.shiro.db.dao.mapper.TbRolePermissionMapper;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbRolePermissionDao {
    @Autowired
    TbRolePermissionMapper tbRolePermissionMapper;
   
    public int insertSelective(TbRolePermission record) {
        return tbRolePermissionMapper.insertSelective(record);
    }

   
    public TbRolePermission selectByPrimaryKey(Long id) {
        return tbRolePermissionMapper.selectByPrimaryKey(id);
    }

   
    public int updateByPrimaryKeySelective(TbRolePermission record) {
        return tbRolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    public int insertList(List<TbRolePermission> pojo) {
        return tbRolePermissionMapper.insertList(pojo);
    }
    public int updateByRoleIdSelective(TbRolePermission record) {
        return tbRolePermissionMapper.updateByRoleIdSelective(record);
    }

}
