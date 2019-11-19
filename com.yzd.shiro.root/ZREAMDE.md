# Shiro配置不起作用问题
> 可能是由于idea 没有拦截上。可以通过打日志的方式验证
# Shiro权限管理
### - 参考文章
- [Shiro + JWT + SpringBoot + MySQL + Redis(Jedis)实现无状态鉴权机制(Restful风格API)](https://blog.csdn.net/wang926454/article/details/82971291)
    - [https://github.com/wang926454/ShiroJwt](https://github.com/wang926454/ShiroJwt)
    - [https://github.com/yaozd/ShiroJwt](https://github.com/yaozd/ShiroJwt)
###  -涛哥-跟我学Shiro
- [Shiro简介——《跟我学Shiro》](https://jinnianshilongnian.iteye.com/blog/2018936)
- [授权——《跟我学Shiro》](https://jinnianshilongnian.iteye.com/blog/2020017)
- [缓存机制——《跟我学Shiro》](https://jinnianshilongnian.iteye.com/blog/2029217)
- [RememberMe——《跟我学Shiro》](https://jinnianshilongnian.iteye.com/blog/2031823)
- [授予身份及切换身份——《跟我学Shiro》](https://jinnianshilongnian.iteye.com/blog/2044616)
- []()

### -Shiro调用流程
```
 请求 -->
 JwtFilter(preHandle)--> 
 JwtFilter(isAccessAllowed)--> 
 JwtFilter(executeLogin)--> 
 UserRealm(supports)--> 
 UserRealm(doGetAuthenticationInfo-AuthenticationToken)-->
 UserRealm(doGetAuthorizationInfo-PrincipalCollection)-->
 处理完成
```
### -[Shiro基础理论](https://jinnianshilongnian.iteye.com/blog/2018936)
```
Authentication：身份认证/登录，验证用户是不是拥有相应的身份；

Authorization：授权，即权限验证，验证某个已认证的用户是否拥有某个权限；即判断用户是否能做事情，常见的如：验证某个用户是否拥有某个角色。或者细粒度的验证某个用户对某个资源是否具有某个权限；

Session Manager：会话管理，即用户登录后就是一次会话，在没有退出之前，它的所有信息都在会话中；会话可以是普通JavaSE环境的，也可以是如Web环境的；

Cryptography：加密，保护数据的安全性，如密码加密存储到数据库，而不是明文存储；

Web Support：Web支持，可以非常容易的集成到Web环境；

Caching：缓存，比如用户登录后，其用户信息、拥有的角色/权限不必每次去查，这样可以提高效率；

Concurrency：shiro支持多线程应用的并发验证，即如在一个线程中开启另一个线程，能把权限自动传播过去；

Testing：提供测试支持；

Run As：允许一个用户假装为另一个用户（如果他们允许）的身份进行访问；

Remember Me：记住我，这个是非常常见的功能，即一次登录后，下次再来的话不用登录了
```
### -Shiro几个关键对象
```
主体（Subject）、资源（Resource）、权限（Permission）、角色（Role）。
```
### -Shiro注解
```
@RequiresRoles("admin")  
@RequiresPermissions("user:online")
@RequiresAuthentication //登录权限
@RequiresUser
@RequiresGuest
```
### -Shiro框架中有三个核心概念：Subject ，SecurityManager和Realms    
