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
    public static final int USER_TOKEN_TTL = 30 * 60 * 1000;

    /**
     * 用户请求和响应头中token的key
     */
    public static final String TOKEN_KEY_IN_REQ_HEADER = "Authorization";

    /**
     * 请求头 / 响应头中的token的前缀
     */
    public static final String TOKEN_KEY_IN_HEADER_PREFIX = "Bearer ";

    /**
     * 系统变量中的token_secret
     */
    public static final String USER_TOKEN_SECRET = System.getenv("USER_TOKEN_SECRET");

    /**
     * token中的accountId的key
     */
    public static final String USER_TOKEN_ACCOUNT_ID_KEY = "accountId";

    /**
     * 用户加密盐值
     */
    public static final String USER_ENCRYPT_VALUE = System.getenv("USER_ENCRYPT_VALUE");
}
