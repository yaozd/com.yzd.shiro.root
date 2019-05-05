package com.yzd.shiro.web.api.controllerApi;

import com.yzd.shiro.web.api.model.request.account.LoginForm;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountControllerApi {
    @ApiOperation(value = "login-登录")
    @PostMapping("login")
    public String login(@RequestBody LoginForm form){
        //
        LoginForm itme=form;
        return "account:login";
    }
}
