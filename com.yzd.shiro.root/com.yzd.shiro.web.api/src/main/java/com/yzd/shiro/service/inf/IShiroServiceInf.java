package com.yzd.shiro.service.inf;

import java.util.Set;

/**
 * 权限管理服务
 */
public interface IShiroServiceInf {
    /**
     * 通过用户ID获得当用户的所有权限标识
     *
     * @param userId
     * @return
     */
    Set<String> findPermissionByUserId(Long userId);
}
