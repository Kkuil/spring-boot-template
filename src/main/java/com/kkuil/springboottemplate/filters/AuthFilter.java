package com.kkuil.springboottemplate.filters;

import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 权限过滤器
 */
public class AuthFilter implements Ordered, WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        return null;
    }

    /**
     * @return 优先级
     * @description 过滤器优先级
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
