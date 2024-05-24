package com.kkuil.springboottemplate.utils;

import cn.hutool.crypto.digest.DigestUtil;

import static com.kkuil.springboottemplate.constant.TokenConst.USER_ENCRYPT_VALUE;

/**
 * @Author Kkuil
 * @Date 2024/1/19 16:52
 * @Description 权限工具类
 */
public class AuthUtils {

    /**
     * 密码加密
     *
     * @param password 原始密码
     */
    public static String encPwd(String password) {
        return DigestUtil.md5Hex(password + USER_ENCRYPT_VALUE);
    }

}
