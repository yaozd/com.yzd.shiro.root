package com.yzd.shiro.web.api.model.response.a1base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一响应结果
 */
@Data
@NoArgsConstructor
public class ResponseResult implements Serializable {
    private String code;
    private String message;
    private Object data;

    private static ResponseResult success(String message){
        ResponseResult item=new ResponseResult();
        item.setCode("200");
        item.setMessage(message);
        return item;
    }
    public static ResponseResult success(){
        return success("success");
    }
    public static ResponseResult success(Object data){
        ResponseResult item=success();
        item.setData(data);
        return item;
    }
    public static ResponseResult fail(Integer code, String error){
        ResponseResult item=new ResponseResult();
        item.setCode(code.toString());
        item.setMessage("fail");
        item.setData(error);
        return item;
    }
}
