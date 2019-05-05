package com.yzd.shiro.web.api.model.request.account;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

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
        tbUser.setIsDel(TbPublicEnum.isDel.NO.CODE);
        return tbUser;


    }
}
