package com.yzd.shiro.web.api.utils.enumExt;

import com.yzd.shiro.web.api.common.exceptionExt.CustomException;

import java.util.Set;

public class EnumUtil {
    /**
     * 检查CODE，从而避免不无效数据进来。
     * @param codes
     * @param val
     * @return
     */
    public static Integer checkCode(String field,Set<Integer> codes, Integer val){
        if(codes.contains(val)){
            return val;
        }
        throw new CustomException(field +"：当前值[" + val + "],没有找到对应的枚举。");
    }
}
