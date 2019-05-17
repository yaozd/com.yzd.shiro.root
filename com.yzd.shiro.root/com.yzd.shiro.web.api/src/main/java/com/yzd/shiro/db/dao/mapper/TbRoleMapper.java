package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;
import com.yzd.shiro.db.entity.where.TbRoleWhere;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbRoleMapper {
    int insertSelective(TbRole record);

    TbRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbRole record);
    //--==================================================自定义脚本==================================================--//

    List<TbRole> selectList(@Param("pojo") TbRole tableWhere, @Param("extendWhere") TbRoleWhere extendWhere, @Param("pageWhere") PageWhere pageWhere);

    Long selectCount(@Param("pojo") TbPermission tableWhere, @Param("extendWhere") TbPermissionWhere extendWhere);
}