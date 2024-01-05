package com.kkuil.springboottemplate.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author Kkuil
 * @Date 2023/12/26 15:56
 * @Description 跨域配置
 */
@ConfigurationProperties(prefix = "cors")
@Data
public class CorsProperties {
    /**
     * 需要跨域的映射
     */
    private String addMapping;

    /**
     * 允许跨域的域名
     */
    private String[] allowedOrigins;

    /**
     * 允许跨域的请求方法
     */
    private String[] allowedMethods;

}
