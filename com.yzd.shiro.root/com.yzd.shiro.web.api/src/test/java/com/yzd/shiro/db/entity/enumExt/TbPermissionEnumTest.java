package com.yzd.shiro.db.entity.enumExt;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Stream;

@Slf4j
public class TbPermissionEnumTest {

    /**
     * 通过反射的方式获得CODE值的集合
     */
    @Test
    public void getCodeListByReflect(){
        Set<Integer> codes= TbEnumExtend.getCodeList(TbPermissionEnum.permissionType.class,"CODE");
        codes.forEach(m->log.info(m+""));
    }

    /**
     * 查验当前CODE值是否有效
     */
    @Test
    public void checkCode(){
        Set<Integer> codes= TbEnumExtend.getCodeList(TbPermissionEnum.permissionType.class,"CODE");
        boolean isExist1=codes.contains(1);
        log.info(isExist1+"");
        boolean isExist2=codes.contains(10);
        log.info(isExist2+"");
    }
}
