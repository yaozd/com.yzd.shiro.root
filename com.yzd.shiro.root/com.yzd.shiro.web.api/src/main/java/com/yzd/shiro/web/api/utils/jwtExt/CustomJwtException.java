package com.yzd.shiro.web.api.utils.jwtExt;

/**
 * JWT 验证异常
 */
public class CustomJwtException extends RuntimeException {
    public CustomJwtException(String msg){
        super(msg);
    }

    public CustomJwtException() {
        super();
    }
}
