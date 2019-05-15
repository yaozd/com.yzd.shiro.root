package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbPermissionMapper {
    int insertSelective(TbPermission record);

    TbPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbPermission record);
    //--==================================================自定义脚本==================================================--//

    List<TbPermission> selectList(@Param("pojo") TbPermission tableWhere, @Param("extendWhere") TbPermissionWhere extendWhere, @Param("pageWhere") PageWhere pageWhere);

    Long selectCount(@Param("pojo") TbPermission tableWhere, @Param("extendWhere") TbPermissionWhere extendWhere);
}