package com.kkuil.biliclone.enums.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.kkuil.biliclone.enums.error.ErrorEnum;

/**
 * @Author Kkuil
 * @Date 2023/9/26
 * @Description 登录校验异常码
 */
@AllArgsConstructor
@Getter
public enum LoginErrorEnum implements ErrorEnum {
    /**
     *
     */
    CAPTCHA_ERROR(10101, "验证码错误"),
    INVALID_TOKEN(10102, "令牌失效，请刷新后再试"),
    NON_LOGIN(10103, "请先登录"),
    ;
    private final Integer code;
    private final String msg;

    /**
     * 获取错误码
     *
     * @return 错误码
     */
    @Override
    public Integer getErrorCode() {
        return this.getCode();
    }

    /**
     * 获取错误信息
     *
     * @return 错误信息
     */
    @Override
    public String getErrorMsg() {
        return this.getMsg();
    }
}
