package com.yzd.shiro.web.api.controllerApi;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserControllerApi {
    @ApiOperation(value = "online-测试权限验证")
    @GetMapping("online")
    @RequiresPermissions("user:online")
    public String online(){
        return "user:online";
    }
    @ApiOperation(value = "view-测试登录认证")
    @GetMapping("view")
    @RequiresAuthentication //登录权限
    public String view(){
        return "user:view";
    }
    @GetMapping("create")
    @RequiresPermissions("user:create")
    public String create(){
        return "user:create";
    }
}
