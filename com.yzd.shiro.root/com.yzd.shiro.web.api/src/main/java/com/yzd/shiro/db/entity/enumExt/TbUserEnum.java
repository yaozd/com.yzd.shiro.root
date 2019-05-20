package com.yzd.shiro.db.entity.enumExt;

public interface TbUserEnum {
    /**
     * 是否在职
     */
    enum jobStatus {
        NO(1, "离职"),
        YES(0, "在职");

        public final Integer CODE;

        jobStatus(Integer code, String desc) {
            this.CODE = code;
        }
    }
}
