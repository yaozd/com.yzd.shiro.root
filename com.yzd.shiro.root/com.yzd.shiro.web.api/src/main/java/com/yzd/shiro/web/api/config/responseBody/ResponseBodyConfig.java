package com.yzd.shiro.web.api.config.responseBody;

import com.yzd.shiro.web.api.model.response.a1base.ResponseResult;
import com.yzd.shiro.web.api.utils.fastjsonExt.FastJsonUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


/**
 * 对返回json进行封装
 * 统一处理的返回值可以保证swagger更友好的显示处理
 */
@ControllerAdvice
public class ResponseBodyConfig implements ResponseBodyAdvice {

    @Value("${swagger.enable}")
    private boolean swaggerShow;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //参考：
        //Springboot使用了ResponseBodyAdvice处理返回值异常？
        //http://www.th7.cn/Program/java/201709/1256116.shtml
        if (obj instanceof String) {
            return FastJsonUtil.serialize(ResponseResult.success(obj));
        }
        if (obj instanceof ResponseResult) {
            return obj;
        }
        if(obj==null){
            return ResponseResult.success(obj);
        }
        //Swagger的请求进行过滤，否则SwaggerUI不能正常显示。
        if(swaggerShow){
            String classTypeName=obj.getClass().getTypeName();
            if(classTypeName.indexOf("springfox")==0){
                return obj;
            }
            String method= methodParameter.getMethod().getName();
            if("swaggerResources".equals(method)){
                return obj;
            }
        }
        return ResponseResult.success(obj);
    }
}
