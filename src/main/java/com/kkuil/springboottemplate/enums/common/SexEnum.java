package com.kkuil.biliclone.enums.common;

import com.kkuil.biliclone.enums.wechat.QrCodeStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author Kkuil
 * @Date 2023/12/25 19:09
 * @Description 性别枚举类
 */
@Getter
@AllArgsConstructor
public enum SexEnum {

    /**
     *
     */
    FEMALE(0, "女"),
    MALE(1, "男"),
    UNKNOWN(2, "未知");

    /**
     * 状态码
     */
    private final Integer code;

    /**
     * 性别
     */
    private final String sex;

    /**
     * 所有状态的缓存
     */
    private static final Map<Integer, SexEnum> CACHE;

    static {
        CACHE = Arrays.stream(SexEnum.values()).collect(Collectors.toMap(SexEnum::getCode, Function.identity()));
    }

    /**
     * 通过状态码获取实体
     *
     * @param code 状态码
     * @return 实体
     */
    public static SexEnum of(Integer code) {
        return CACHE.get(code);
    }

}
