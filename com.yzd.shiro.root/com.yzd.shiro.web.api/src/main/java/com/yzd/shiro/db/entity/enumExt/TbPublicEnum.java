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
}
