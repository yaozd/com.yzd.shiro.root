package com.yzd.shiro.web.api.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserRealm extends AuthorizingRealm {


    /**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }

    /**
     *  权限验证（Authorization）-- 权限验证简称authz
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        // 添加角色
        simpleAuthorizationInfo.addRole("admin");
        // 添加权限--超级管理员--访问所有
        //simpleAuthorizationInfo.addStringPermission("*");
        // 添加权限--具体权限
        simpleAuthorizationInfo.addStringPermission("user:online");
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证 （Authentication）-- 登录认证简称authc
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        log.info("token="+token);
        return new SimpleAuthenticationInfo(token, token, "userRealm");
        //throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    }
}

