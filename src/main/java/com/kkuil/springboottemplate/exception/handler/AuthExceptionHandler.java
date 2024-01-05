package com.kkuil.springboottemplate.exception.handler;

import com.kkuil.biliclone.constant.GlobalConst;
import com.kkuil.biliclone.exception.UnAuthorizationException;
import com.kkuil.biliclone.utils.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler(value = UnAuthorizationException.class)
    public ResultUtil<Boolean> handleAuthException(UnAuthorizationException e) {
        if (GlobalConst.EMPTY_STR.equals(e.getMessage())) {
            return ResultUtil.error(DEFAULT_UNAUTH_MESSAGE, false);
        }
        return ResultUtil.error(e.getCode(), e.getMessage(), false);
    }
}
