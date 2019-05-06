package com.yzd.shiro.web.api.config.exception;

import com.yzd.shiro.web.api.common.exceptionExt.CustomException;
import com.yzd.shiro.web.api.common.exceptionExt.ExceptionEnum;
import com.yzd.shiro.web.api.model.response.a1base.ResponseResult;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常控制处理器
 * @author Wang926454
 * @date 2018/8/30 14:02
 */
@RestControllerAdvice
public class ExceptionAdviceConfig {
    /**
     * 捕捉所有Shiro异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public ResponseResult handle401(ShiroException e) {
        return ResponseResult.fail(HttpStatus.UNAUTHORIZED.value(), "无权访问(Unauthorized):" + e.getMessage());
    }
    /**
     * 单独捕捉Shiro(UnauthorizedException)异常
     * 该异常为访问有权限管控的请求而该用户没有所需权限所抛出的异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseResult handle401(UnauthorizedException e) {
        return ResponseResult.fail(HttpStatus.UNAUTHORIZED.value(), "无权访问(Unauthorized):当前Subject没有此请求所需权限(" + e.getMessage() + ")");
    }

    /**
     * 单独捕捉Shiro(UnauthenticatedException)异常
     * 该异常为以游客身份访问有权限管控的请求无法对匿名主体进行授权，而授权失败所抛出的异常
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseResult handle401(UnauthenticatedException e) {
        return ResponseResult.fail(HttpStatus.UNAUTHORIZED.value(), "无权访问(Unauthorized):当前Subject是匿名Subject，请先登录(This subject is anonymous.)");
    }
    /**
     * 捕捉404异常
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseResult handle(NoHandlerFoundException e) {
        return ResponseResult.fail(HttpStatus.NOT_FOUND.value(), e.getMessage());
    }
    /**
     * 捕捉其他所有异常
     * @param request
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseResult globalException(HttpServletRequest request, Throwable ex) {
        return ResponseResult.fail(this.getStatus(request).value(), ex.toString() + ": " + ex.getMessage());
    }

    /**
     * 获取状态码
     * @param request
     * @return
     */
    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

    /**
     * 自定义异常
     * 因为自定义异常需要做业务逻辑处理，所以使用HttpStatus.OK
     * @param ex
     * @return
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(CustomException.class)
    public ResponseResult handleCustomException(Throwable ex) {
        return ResponseResult.fail(ExceptionEnum.CUSTOM_ERROR.CODE, ex.getMessage());
    }

}
