package com.yzd.shiro.db.entity.enumExt;

public interface TbUserEnum {
    /**
     * 是否在职
     */
    enum isJob {
        NO(false, "离职"),
        YES(true, "正常");

        public final Boolean CODE;

        isJob(boolean code, String desc) {
            this.CODE = code;
        }
    }
}
