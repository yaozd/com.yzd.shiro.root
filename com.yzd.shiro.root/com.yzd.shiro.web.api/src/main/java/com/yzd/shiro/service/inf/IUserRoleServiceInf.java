package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserRoleWhere;

import java.util.List;

public interface IUserRoleServiceInf {
    int insertSelective(TbUserRole record);

    TbUserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbUserRole record);
    //--==================================================自定义脚本==================================================--//

    List<TbUserRole> selectList(TbUserRole tableWhere, TbUserRoleWhere extendWhere, PageWhere pageWhere);

    Long selectCount(TbUserRole tableWhere, TbUserRoleWhere extendWhere);
}
