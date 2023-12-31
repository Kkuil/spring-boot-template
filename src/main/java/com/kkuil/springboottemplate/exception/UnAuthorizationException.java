package com.kkuil.springboottemplate.exception;

import com.kkuil.biliclone.enums.error.ErrorEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;

/**
 * @Author Kkuil
 * @Date 2023/9/4 10:43
 * @Description 未登录异常
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class UnAuthorizationException extends RuntimeException {

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

    public UnAuthorizationException() {
        super();
    }

    public UnAuthorizationException(String message) {
        super(message);
        this.message = message;
    }

    public UnAuthorizationException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public UnAuthorizationException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
    }

    public UnAuthorizationException(ErrorEnum error) {
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
