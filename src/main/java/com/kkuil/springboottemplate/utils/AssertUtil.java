package com.kkuil.springboottemplate.utils;

import cn.hutool.core.util.ObjectUtil;
import com.kkuil.biliclone.enums.error.BusinessErrorEnum;
import com.kkuil.biliclone.enums.error.ErrorEnum;
import com.kkuil.springboottemplate.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * @Author Kkuil
 * @Date 2023/9/26
 * @Description 校验工具类
 */
@Slf4j(topic = "assert")
public class AssertUtil {

    /**
     * 如果不是true，则抛异常
     *
     * @param expression 布尔表达式
     * @param errorEnum  错误枚举
     */
    public static void isTrue(boolean expression, ErrorEnum errorEnum) {
        if (!expression) {
            throwException(errorEnum);
        }
    }

    /**
     * 如果不是true，则抛异常
     *
     * @param expression 布尔表达式
     * @param msg        错误消息
     */
    public static void isTrue(boolean expression, String msg) {
        if (!expression) {
            throwException(msg);
        }
    }

    /**
     * 如果是true，则抛异常
     *
     * @param expression 布尔表达式
     * @param errorEnum  错误枚举
     */
    public static void isFalse(boolean expression, ErrorEnum errorEnum) {
        if (expression) {
            throwException(errorEnum);
        }
    }

    /**
     * 如果是true，则抛异常
     *
     * @param expression 布尔表达式
     * @param msg        错误消息
     */
    public static void isFalse(boolean expression, String msg) {
        if (expression) {
            throwException(msg);
        }
    }

    /**
     * 如果不是非空对象，则抛异常
     *
     * @param obj       对象
     * @param errorEnum 错误枚举
     */
    public static void isNotEmpty(Object obj, ErrorEnum errorEnum) {
        if (isEmpty(obj)) {
            throwException(errorEnum);
        }
    }

    /**
     * 如果不是非空对象，则抛异常
     *
     * @param obj 对象
     * @param msg 错误消息
     */
    public static void isNotEmpty(Object obj, String msg) {
        if (isEmpty(obj)) {
            throwException(msg);
        }
    }

    /**
     * 如果不是非空对象，则抛异常
     *
     * @param obj       对象
     * @param errorEnum 错误枚举
     */
    public static void isEmpty(Object obj, ErrorEnum errorEnum) {
        if (!isEmpty(obj)) {
            throwException(errorEnum);
        }
    }

    /**
     * 如果不是非空对象，则抛异常
     *
     * @param obj 对象
     * @param msg 错误消息
     */
    public static void isEmpty(Object obj, String msg) {
        if (!isEmpty(obj)) {
            throwException(msg);
        }
    }

    /**
     * 如果不相等，则抛异常
     *
     * @param o1        对象1
     * @param o2        对象2
     * @param errorEnum 错误枚举
     */
    public static void equal(Object o1, Object o2, ErrorEnum errorEnum) {
        if (!ObjectUtil.equal(o1, o2)) {
            throwException(errorEnum);
        }
    }

    /**
     * 如果不相等，则抛异常
     *
     * @param o1  对象1
     * @param o2  对象2
     * @param msg 错误消息
     */
    public static void equal(Object o1, Object o2, String msg) {
        if (!ObjectUtil.equal(o1, o2)) {
            throwException(msg);
        }
    }


    /**
     * 如果相等，则抛异常
     *
     * @param o1        对象1
     * @param o2        对象2
     * @param errorEnum 错误消息枚举
     */
    public static void notEqual(Object o1, Object o2, ErrorEnum errorEnum) {
        if (ObjectUtil.equal(o1, o2)) {
            throwException(errorEnum);
        }
    }

    /**
     * 如果不是非空对象，则抛异常
     *
     * @param obj 对象
     */
    private static boolean isEmpty(Object obj) {
        return ObjectUtil.isEmpty(obj);
    }

    private static void throwException(String msg) {
        throw new BusinessException(400, msg);
    }

    private static void throwException(ErrorEnum errorEnum) {
        if (Objects.isNull(errorEnum)) {
            errorEnum = BusinessErrorEnum.BUSINESS_ERROR;
        }
        log.info("errorEnum: {}", errorEnum.getErrorMsg());
        throw new BusinessException(errorEnum.getErrorCode(), errorEnum.getErrorMsg());
    }
}
