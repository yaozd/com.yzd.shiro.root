package com.yzd.shiro.web.api.model.request.account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginForm {
    private String name;
    private String password;
}
