package com.kkuil.springboottemplate.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 登录拦截器
 */
@Component
@Slf4j(topic = "authInterceptor")
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        // 拦截token
        return true;
    }
}
