package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbRolePermission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRolePermissionMapper {
    int insertSelective(TbRolePermission record);

    TbRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRolePermission record);

    //--==================================================自定义脚本==================================================--//
    int insertList(@Param("pojos") List<TbRolePermission> pojo);

    int updateByRoleIdSelective(TbRolePermission record);
}