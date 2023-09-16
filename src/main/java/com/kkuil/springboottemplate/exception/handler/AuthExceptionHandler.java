package com.kkuil.springboottemplate.exception.handler;

import com.kkuil.springboottemplate.exception.UnAuthorizationException;
import com.kkuil.common.utils.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.kkuil.springboottemplate.constant.GlobalConst.EMPTY_STR;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 权限异常处理器
 */
@RestControllerAdvice
public class AuthExceptionHandler {

    /**
     * 默认未授权异常信息
     */
    public static final String DEFAULT_UNAUTH_MESSAGE = "请先登录";

    /**
     * @param e Exception
     * @return ResponseEntity
     * @description 处理未登录异常
     */
    @ExceptionHandler(value = UnAuthorizationException.class)
    public ResultUtil<Boolean> handleAuthException(UnAuthorizationException e) {
        if (EMPTY_STR.equals(e.getMessage())) {
            return ResultUtil.error(DEFAULT_UNAUTH_MESSAGE, false);
        }
        return ResultUtil.error(e.getMessage(), false);
    }
}
