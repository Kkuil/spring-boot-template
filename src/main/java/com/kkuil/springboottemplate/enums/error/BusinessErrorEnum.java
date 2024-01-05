package com.kkuil.biliclone.enums.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import com.kkuil.biliclone.enums.error.ErrorEnum;

/**
 * @Author Kkuil
 * @Date 2023/9/26
 * @Description 业务校验异常码
 */
@AllArgsConstructor
@Getter
public enum BusinessErrorEnum implements ErrorEnum {
    /**
     *
     */
    BUSINESS_ERROR(10001, "{0}"),
    SYSTEM_ERROR(10002, "系统出小差了，请稍后再试哦~~"),
    ;
    private final Integer code;
    private final String msg;

    /**
     * 获取错误码
     * * @return 错误码
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
