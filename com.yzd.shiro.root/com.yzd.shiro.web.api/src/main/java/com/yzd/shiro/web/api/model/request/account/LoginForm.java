package com.yzd.shiro.web.api.model.request.account;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.web.api.config.shiro.CurrentToken;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class LoginForm {
    @ApiModelProperty(value = "用户名",example = "15012345678")
    private String name;
    @ApiModelProperty(value = "密码",example = "123456")
    private String password;

    public static TbUser toEntity(LoginForm form) {
        TbUser tbUser = new TbUser();
        tbUser.setMobile(form.getName());
        return tbUser;


    }

    public static CurrentToken toCurrentToken(TbUser item) {
        CurrentToken currentToken = new CurrentToken();
        currentToken.setId(item.getId());
        currentToken.setName(item.getUsername());
        currentToken.setUuid(UUID.randomUUID().toString());
        //当前的数据版本，暂时为1。
        currentToken.setVersion(1);
        return currentToken;
    }
}
