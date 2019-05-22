package com.yzd.shiro.db.dao.mapper;

import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserWhere;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbUserMapper {
    int insertSelective(TbUser record);

    TbUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUser record);
    //--==================================================自定义脚本==================================================--//

    List<TbUser> selectList(@Param("pojo")TbUser tableWhere, @Param("extendWhere")TbUserWhere extendWhere,@Param("pageWhere")PageWhere pageWhere);
}