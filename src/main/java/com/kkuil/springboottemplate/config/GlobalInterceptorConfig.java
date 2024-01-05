package com.kkuil.springboottemplate.config;

import com.kkuil.springboottemplate.interceptors.AuthInterceptor;
import com.kkuil.springboottemplate.interceptors.LogInterceptor;
import com.kkuil.springboottemplate.property.CorsProperties;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @Author Kkuil
 * @Description 全局拦截器配置
 * @Date 2023/09/03
 */
@Configuration
@AllArgsConstructor
@EnableConfigurationProperties(CorsProperties.class)
public class GlobalInterceptorConfig implements WebMvcConfigurer {

    /**
     * 白名单
     */
    public static final List<String> WEB_URL_WHITELIST = List.of(
            "/user/login",
            "/user/register"
    );

    private CorsProperties corsProperties;

    /**
     * 拦截器
     *
     * @param interceptorRegistry 拦截器注册器
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {
        interceptorRegistry.addInterceptor(new LogInterceptor());
        interceptorRegistry.addInterceptor(new AuthInterceptor())
                .excludePathPatterns(WEB_URL_WHITELIST);
    }

    /**
     * 跨域
     *
     * @param corsRegistry 跨域注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry) {
        corsRegistry.addMapping(corsProperties.getAddMapping())
                .allowedOrigins(corsProperties.getAllowedOrigins())
                .allowedMethods(corsProperties.getAllowedMethods())
                .allowedHeaders("*")
                .exposedHeaders("*");
    }
}
