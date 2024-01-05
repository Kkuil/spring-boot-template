package com.kkuil.springboottemplate.domain.dto.request;

import lombok.ToString;

/**
 * @Author Kkuil
 * @Date 2023/12/27 10:16
 * @Description 用户信息持有器工具类
 */
@ToString
public class RequestHolder {

    private static final ThreadLocal<RequestInfoDTO> THREAD_LOCAL = new ThreadLocal<>();

    public static void set(RequestInfoDTO requestInfo) {
        THREAD_LOCAL.set(requestInfo);
    }

    public static RequestInfoDTO get() {
        return THREAD_LOCAL.get();
    }

    public static void remove() {
        THREAD_LOCAL.remove();
    }

}
