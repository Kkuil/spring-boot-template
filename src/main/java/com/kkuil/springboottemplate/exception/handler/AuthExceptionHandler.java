package com.kkuil.springboottemplate.exception.handler;

import com.kkuil.springboottemplate.exception.UnAuthorizationException;
import com.kkuil.sqleasy.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.kkuil.sqleasy.constant.GlobalConst.EMPTY_STR;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 权限异常处理器
 */
@ControllerAdvice
public class AuthExceptionHandler {
    /**
     * @param e Exception
     * @return ResponseEntity
     * @description 处理未登录异常
     */
    @ExceptionHandler(value = UnAuthorizationException.class)
    public ResultUtil<Boolean> handleAuthException(UnAuthorizationException e) {
        if (EMPTY_STR.equals(e.getMessage())) {
            return ResultUtil.error("请先登录", false);
        }
        return ResultUtil.error(e.getMessage(), false);
    }
}
