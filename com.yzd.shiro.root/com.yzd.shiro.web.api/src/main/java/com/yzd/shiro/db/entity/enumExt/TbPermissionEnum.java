package com.yzd.shiro.db.entity.enumExt;

import java.util.*;

public interface TbPermissionEnum {
    /**
     * 可见状态:VISIBLE(1=可见)、HIDDEN(2=隐藏)
     */
    enum visibleStatus {
        VISIBLE(1, "可见"),
        HIDDEN(2, "隐藏");

        public final Integer CODE;

        visibleStatus(int code, String desc) {
            this.CODE = code;
        }
        public static final Set<Integer> CODES=TbEnumExtend.getCodeList(visibleStatus.class);

    }

    /**
     * 启用状态:YES(1=启用)、NO(2=停用）
     */
    enum enableStatus {
        /**
         * 启用
         */
        YES(1, "启用"),
        /**
         * 停用
         */
        NO(2, "停用");
        public final Integer CODE;

        enableStatus(int code, String desc) {
            this.CODE = code;
        }
        public static final Set<Integer> CODES=TbEnumExtend.getCodeList(enableStatus.class);
    }

    enum permissionType {
        CATALOG(1, "目录"),
        MENU(2, "菜单"),
        FEATURE(3, "功能"),
        BUTTON(4, "按钮");

        public final Integer CODE;

        permissionType(int code, String desc) {
            this.CODE = code;
        }
        public static final Set<Integer> CODES=TbEnumExtend.getCodeList(permissionType.class);
    }
}
