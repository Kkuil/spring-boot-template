package com.kkuil.springboottemplate.exception.handler;

import com.kkuil.biliclone.exception.BusinessException;
import com.kkuil.biliclone.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 业务异常处理器
 */
@RestControllerAdvice
@Slf4j(topic = "business-exception")
public class BusinessExceptionHandler {
    @ExceptionHandler(value = BusinessException.class)
    public ResultUtil<Boolean> businessException(BusinessException e) {
        log.info("Business message: {}", e.getMessage());
        return ResultUtil.error(e.getCode(), e.getMessage(), false);
    }
}
