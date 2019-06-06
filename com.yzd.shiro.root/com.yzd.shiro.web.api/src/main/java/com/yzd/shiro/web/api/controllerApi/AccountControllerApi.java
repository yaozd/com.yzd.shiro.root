package com.yzd.shiro.web.api.controllerApi;

import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.service.inf.IUserServiceInf;
import com.yzd.shiro.web.api.common.exceptionExt.CustomException;
import com.yzd.shiro.web.api.config.shiro.CurrentToken;
import com.yzd.shiro.web.api.config.shiro.JwtToken;
import com.yzd.shiro.web.api.model.request.account.LoginForm;
import com.yzd.shiro.web.api.utils.jwtExt.JwtUtil;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class AccountControllerApi {
    @Autowired
    IUserServiceInf userServiceInf;

    @ApiOperation(value = "login-登录")
    @PostMapping("login")
    public String login(@RequestBody LoginForm form,HttpServletResponse response){
        //
        TbUser where=LoginForm.toEntity(form);
        TbUser item= userServiceInf.selectOne(where,null);
        if(item==null){
           throw new CustomException("用户名或密码不正确");
        }
        //设置TOKEN
        CurrentToken currentToken=LoginForm.toCurrentToken(item);
        String token=JwtUtil.createToken(currentToken);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        //
        return "account:login-true";
    }
}
