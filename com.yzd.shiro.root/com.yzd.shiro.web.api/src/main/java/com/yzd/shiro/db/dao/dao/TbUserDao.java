package com.yzd.shiro.db.dao.dao;

import com.yzd.shiro.db.dao.mapper.TbUserMapper;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.db.entity.where.TbUserWhere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TbUserDao  {
    @Autowired
    TbUserMapper tbUserMapper;

    public int insertSelective(TbUser record) {
        return tbUserMapper.insertSelective(record);
    }

    public TbUser selectByPrimaryKey(Integer id) {
        return null;
    }

    public int updateByPrimaryKeySelective(TbUser record) {
        return 0;
    }

    public List<TbUser> selectList(TbUser tableWhere, TbUserWhere extendWhere,PageWhere pageWhere) {
        return tbUserMapper.selectList(tableWhere,extendWhere,pageWhere);
    }
    public TbUser selectOne(TbUser tableWhere, TbUserWhere extendWhere){
        List<TbUser> itemList=selectList(tableWhere,extendWhere,PageWhere.newPage4One());
        return itemList.stream().findFirst().orElseGet(()->null);
    }
}
