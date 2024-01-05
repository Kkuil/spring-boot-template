package com.kkuil.springboottemplate.exception.handler;

import com.kkuil.biliclone.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 异常处理器
 */
@RestControllerAdvice
@Slf4j(topic = "global")
public class GlobalExceptionHandler {

    /**
     * 系统错误默认消息
     */
    public static final String SYSTEM_ERROR_MESSAGE = "系统出了点小差，请稍后再试哦~~";

    /**
     * @param e Exception
     * @return ResponseEntity
     * @description 处理所有不可知的异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResultUtil<Boolean> handleException(Exception e) {
        String message = e.getMessage();
        log.error("系统异常：{}", message);
        return ResultUtil.error(HttpStatus.INTERNAL_SERVER_ERROR.value(), SYSTEM_ERROR_MESSAGE, false);
    }
}
