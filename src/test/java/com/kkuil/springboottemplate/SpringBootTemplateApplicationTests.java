package com.kkuil.springboottemplate;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringBootTemplateApplicationTests {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    void testJasypt() {
        String username = "username";
        String password = "password";
        String encryptUsername = stringEncryptor.encrypt(username);
        String encryptPassword = stringEncryptor.encrypt(password);
        System.out.println("encryptUsername = " + encryptUsername);
        System.out.println("encryptPassword = " + encryptPassword);
    }
}
