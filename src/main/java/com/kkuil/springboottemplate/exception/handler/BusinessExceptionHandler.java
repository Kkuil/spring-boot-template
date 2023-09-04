package com.kkuil.springboottemplate.exception.handler;

import com.kkuil.springboottemplate.exception.NecessaryFieldsIsEmptyException;
import com.kkuil.sqleasy.utils.ResultUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author kkuil
 * @Date 2023/08/03 23:00
 * @Description 业务异常处理器
 */
@ControllerAdvice
public class BusinessExceptionHandler {
    /**
     * @param e NecessaryFieldsIsEmptyException
     * @return ResultUtil<Boolean>
     * @description 必要字段为空异常
     */
    @ExceptionHandler(value = NecessaryFieldsIsEmptyException.class)
    public ResultUtil<Boolean> handleAuthException(NecessaryFieldsIsEmptyException e) {
        return ResultUtil.error(e.getMessage(), false);
    }
}
