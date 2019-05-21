package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserRoleWhere;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserRoleMapper {
    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUserRole record);
    //--==================================================自定义脚本==================================================--//

    List<TbUserRole> selectList(@Param("pojo") TbUserRole tableWhere, @Param("extendWhere") TbUserRoleWhere extendWhere, @Param("pageWhere") PageWhere pageWhere);

    Long selectCount(@Param("pojo") TbUserRole tableWhere, @Param("extendWhere") TbUserRoleWhere extendWhere);
}