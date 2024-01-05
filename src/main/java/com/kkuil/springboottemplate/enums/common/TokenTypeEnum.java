package com.kkuil.biliclone.enums.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @Author Kkuil
 * @Date 2023/12/25 19:09
 * @Description token类型枚举类
 */
@Getter
@AllArgsConstructor
public enum TokenTypeEnum {

    /**
     *
     */
    ACCESS_TOKEN("access_token"),
    REFRESH_TOKEN("refresh_token");

    /**
     * 性别
     */
    private final String desc;
}
