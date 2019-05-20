package com.yzd.shiro.service.impl;

import com.yzd.shiro.service.inf.IUserRoleServiceInf;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import startup.BaseUnitTest;

@Slf4j
public class UserRoleServiceImplTest extends BaseUnitTest {

    @Autowired
    IUserRoleServiceInf iUserRoleServiceInf;

    @Test
    public void selectByPrimaryKey() {
        iUserRoleServiceInf.selectByPrimaryKey(1l);
    }
}
