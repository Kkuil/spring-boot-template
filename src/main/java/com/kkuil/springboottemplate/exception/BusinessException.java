package com.kkuil.springboottemplate.exception;

import com.kkuil.biliclone.enums.error.ErrorEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @Author Kkuil
 * @Date 2023/9/26
 * @Description 业务异常类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected Integer code;

    /**
     * 错误信息
     */
    protected String message;

    public BusinessException() {
        super();
    }

    public BusinessException(String message) {
        super(message);
        this.message = message;
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public BusinessException(ErrorEnum error) {
        super(error.getErrorMsg());
        this.code = error.getErrorCode();
        this.message = error.getErrorMsg();
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
