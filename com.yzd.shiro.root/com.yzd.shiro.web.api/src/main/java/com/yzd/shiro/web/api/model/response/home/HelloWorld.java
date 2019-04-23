package com.yzd.shiro.web.api.model.response.home;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class HelloWorld implements Serializable {
    private String name;
}
