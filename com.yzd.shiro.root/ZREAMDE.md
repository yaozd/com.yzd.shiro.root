# Shiro权限管理
### - 参考文章
- [Shiro + JWT + SpringBoot + MySQL + Redis(Jedis)实现无状态鉴权机制(Restful风格API)](https://blog.csdn.net/wang926454/article/details/82971291)
    - [https://github.com/wang926454/ShiroJwt](https://github.com/wang926454/ShiroJwt)
    - [https://github.com/yaozd/ShiroJwt](https://github.com/yaozd/ShiroJwt)

### -Shiro调用流程
```
 请求 -->
 JwtFilter(isAccessAllowed)--> 
 JwtFilter(executeLogin)--> 
 UserRealm(supports)--> 
 UserRealm(doGetAuthenticationInfo-AuthenticationToken)-->
 UserRealm(doGetAuthorizationInfo-PrincipalCollection)-->
 处理完成
```
    
