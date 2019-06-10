package com.yzd.shiro.web.api.config.shiro;

import com.yzd.shiro.service.inf.IShiroServiceInf;
import com.yzd.shiro.web.api.utils.fastjsonExt.FastJsonUtil;
import com.yzd.shiro.web.api.utils.jwtExt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Slf4j
@Component
public class UserRealm extends AuthorizingRealm {

    @Autowired
    IShiroServiceInf iShiroServiceInf;

    /**
     * 大坑，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }

    /**
     * 权限验证（Authorization）-- 权限验证简称authz
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String token = principalCollection.toString();
        CurrentToken currentToken = JwtUtil.jsonToUser(token, CurrentToken.class);
        // 查询用户角色
        Set<String> itemSet4Permission = iShiroServiceInf.findPermissionByUserId(currentToken.getId());
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(itemSet4Permission);
        // 添加角色
        //simpleAuthorizationInfo.addRole("admin");
        // 添加权限--超级管理员--访问所有
        //simpleAuthorizationInfo.addStringPermission("*");
        // 添加权限--具体权限
        //simpleAuthorizationInfo.addStringPermission("user:online");
        return simpleAuthorizationInfo;
    }

    /**
     * 登录认证 （Authentication）-- 登录认证简称authc
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) {
        String token4json = (String) authenticationToken.getCredentials();
        log.info("token=" + token4json);
        CurrentToken currentToken = JwtUtil.jsonToUser(token4json, CurrentToken.class);
        log.info("CURRENT TOKEN:" + FastJsonUtil.serialize(currentToken));
        // 查询用户是否存在
        return new SimpleAuthenticationInfo(token4json, token4json, "userRealm");
        //throw new AuthenticationException("Token已过期(Token expired or incorrect.)");
    }
}

