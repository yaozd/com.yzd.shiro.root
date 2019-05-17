package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbRolePermissionWhere;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRolePermissionMapper {
    int insertSelective(TbRolePermission record);

    TbRolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRolePermission record);

    //--==================================================自定义脚本==================================================--//
    int insertList(@Param("pojos") List<TbRolePermission> pojo);

    int updateByRoleIdSelective(TbRolePermission record);

    List<TbRolePermission> selectList(@Param("pojo") TbRolePermission tableWhere, @Param("extendWhere") TbRolePermissionWhere extendWhere, @Param("pageWhere") PageWhere pageWhere);

    Long selectCount(@Param("pojo") TbPermission tableWhere, @Param("extendWhere") TbRolePermissionWhere extendWhere);
}