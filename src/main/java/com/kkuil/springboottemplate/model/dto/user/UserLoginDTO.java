package com.kkuil.springboottemplate.model.dto.user;

import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/9/3 16:37
 * @Description 用户登录提交信息
 */
@Data
public class UserLoginDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
