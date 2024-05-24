package com.kkuil.springboottemplate.service;

import jakarta.servlet.http.HttpServletResponse;

/**
 * @Author Kkuil
 * @Date 2023/12/23 17:06
 * @Description 用户服务接口
 */
public interface IUserLoginService {

    /**
     * token生成
     *
     * @param accountId 账户ID
     * @return token
     */
    String generateToken(Long accountId);

    /**
     * 保存响应头中
     *
     * @param response    响应对象
     * @param token token对象
     */
    void saveTokenInHeader(HttpServletResponse response, String token);
}
