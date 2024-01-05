package com.kkuil.springboottemplate.constant;

/**
 * @Author 小K
 * @Date 2023/08/03 23:00
 * @Description 用户常量
 */
public class TokenConst {
    /**
     * 用户access_token过期时间 (30分钟)
     */
    public static final int USER_ACCESS_TOKEN_TTL = 30 * 60 * 1000;

    /**
     * 用户refresh_token过期时间  (60分钟)
     */
    public static final int USER_REFRESH_TOKEN_TTL = 2 * 30 * 60 * 1000;

    /**
     * 用户请求头中token的key
     */
    public static final String TOKEN_KEY_IN_REQ_HEADER = "Authorization";

    /**
     * 用户响应头中access_token的key
     */
    public static final String ACCESS_TOKEN_KEY_IN_RESP_HEADER = "X-Access-Token";

    /**
     * 用户响应头中refresh_token的key
     */
    public static final String REFRESH_TOKEN_KEY_IN_RESP_HEADER = "X-Refresh-Token";

    /**
     * 请求头 / 响应头中的token的前缀
     */
    public static final String TOKEN_KEY_IN_HEADER_PREFIX = "Bearer ";

    /**
     * 系统变量中的盐值user_encrypt_value
     */
    public static final String USER_ENCRYPT_VALUE_ENV = "USER_ENCRYPT_VALUE";

    /**
     * 系统变量中的token_secret
     */
    public static final String USER_TOKEN_SECRET_ENV = "USER_TOKEN_SECRET";

    /**
     * token中的accountId的key
     */
    public static final String USER_TOKEN_ACCOUNT_ID_KEY = "accountId";

    /**
     * token中的tokenType的key
     */
    public static final String USER_TOKEN_TYPE_KEY = "tokenType";
}
