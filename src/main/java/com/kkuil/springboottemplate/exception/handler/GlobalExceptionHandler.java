package com.kkuil.springboottemplate.exception.handler;

import com.kkuil.common.utils.ResultUtil;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * @param e Exception
     * @return ResponseEntity
     * @description 处理所有不可知的异常
     */
    @ExceptionHandler(value = Exception.class)
    public ResultUtil<Boolean> handleException(Exception e) {
        return ResultUtil.error(e.getMessage(), false);
    }
}
