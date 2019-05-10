package com.yzd.shiro.db.entity.enumExt;

/**
 * 数据库所有表中的公共枚举集合
 */
public interface TbPublicEnum {
    /**
     * 是否删除
     */
    enum isDel {
        NO(false, "有效数据"),
        YES(true, "无效数据");

        public final Boolean CODE;

        isDel(boolean code, String desc) {
            this.CODE = code;
        }
    }
    /**
     * 是否删除:NO(0=有效数据)、YES(1=无效数据)
     */
    enum gmtIsDel {
        /**
         * 有效数据
         */
        NO(0, "有效数据"),
        /**
         * 无效数据
         */
        YES(1, "无效数据");

        public final Integer CODE;

        gmtIsDel(int code, String desc) {
            this.CODE = code;
        }
    }
}
