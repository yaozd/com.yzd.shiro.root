package com.yzd.shiro.service.impl;
import java.util.Date;
import java.util.List;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.enumExt.TbUserEnum;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.service.inf.IUserServiceInf;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import startup.BaseUnitTest;

@Slf4j
public class UserServiceImplTest extends BaseUnitTest {

    @Autowired
    IUserServiceInf userServiceInf;
    @Test
    public void insertSelective() {
        TbUser record=new TbUser();
        record.setUsername("yzd");
        record.setMobile("15012345678");
        record.setPassword("123456");
        record.setInsertUid(0);
        record.setInsertUid(0);
        record.setJobStatus(TbUserEnum.jobStatus.YES.CODE);
        record.setVersion(0);
        record.setGmtCreateTime(new Date());
        record.setGmtUpdateTime(new Date());
        record.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        userServiceInf.insertSelective(record);
    }

    @Test
    public void selectByPrimaryKey() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void selectList() {
        List<TbUser> itemList= userServiceInf.selectList(null,null,null);
        log.info("itemList.size():"+itemList.size());
    }

    @Test
    public void selectOne() {
        TbUser item=userServiceInf.selectOne(null,null);
        Assert.assertNotNull(item);
    }
}
