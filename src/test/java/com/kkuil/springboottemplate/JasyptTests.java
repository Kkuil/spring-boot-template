package com.kkuil.springboottemplate;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JasyptTests {

    @Autowired
    private StringEncryptor stringEncryptor;

    /**
     * 获取加密后的mysql账密
     */
    @Test
    void execOther() {
        String test = "3308";
        String encryptTest = stringEncryptor.encrypt(test);
        System.out.println("encryptTest = " + encryptTest);
    }

    /**
     * 获取加密后的mysql账密
     */
    @Test
    void execMysql() {
        String username = "username";
        String password = "password";
        String encryptUsername = stringEncryptor.encrypt(username);
        String encryptPassword = stringEncryptor.encrypt(password);
        System.out.println("encryptUsername = " + encryptUsername);
        System.out.println("encryptPassword = " + encryptPassword);
    }

    /**
     * 获取加密后的redis密码
     */
    @Test
    void execRedis() {
        String password = "password";
        String encryptPassword = stringEncryptor.encrypt(password);
        System.out.println("encryptPassword = " + encryptPassword);
    }

    /**
     * 获取加密后的短信信息
     */
    @Test
    void execCaptcha() {
        String signName = "123456";
        String templateCode = "123456";
        String accessKeyId = "123456";
        String accessKeySecret = "123456";
        String encryptSignName = stringEncryptor.encrypt(signName);
        String encryptTemplateCode = stringEncryptor.encrypt(templateCode);
        String encryptAccessKeyId = stringEncryptor.encrypt(accessKeyId);
        String encryptAccessKeySecret = stringEncryptor.encrypt(accessKeySecret);
        System.out.println("signName = " + encryptSignName);
        System.out.println("templateCode = " + encryptTemplateCode);
        System.out.println("accessKeyId = " + encryptAccessKeyId);
        System.out.println("accessKeySecret = " + encryptAccessKeySecret);
    }
}
