package com.yzd.shiro.service.inf;

import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbPermissionWhere;

import java.util.List;

public interface IPermissionServiceInf {
    int insertSelective(TbPermission record);

    TbPermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TbPermission record);

    List<TbPermission> selectList(TbPermission tableWhere, TbPermissionWhere extendWhere, PageWhere pageWhere);

    Long selectCount(TbPermission tableWhere, TbPermissionWhere extendWhere);
}
