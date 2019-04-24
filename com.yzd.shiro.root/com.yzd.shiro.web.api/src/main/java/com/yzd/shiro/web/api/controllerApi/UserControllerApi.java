package com.yzd.shiro.web.api.controllerApi;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserControllerApi {
    @GetMapping("online")
    @RequiresPermissions("user:online")
    public String online(){
        return "user:online";
    }
}
