package com.kkuil.springboottemplate.service;

import com.kkuil.springboottemplate.domain.bo.auth.TokenBO;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @Author Kkuil
 * @Date 2023/12/23 17:06
 * @Description 用户服务接口
 */
public interface UserService {

    /**
     * 双token生成
     *
     * @param accountId 账户ID
     * @return 双token
     */
    TokenBO generateDoubleToken(Long accountId);

    /**
     * 保存响应头中...
     *
     * @param response    响应对象
     * @param doubleToken 双token对象
     */
    void saveTokenInHeader(HttpServletResponse response, TokenBO doubleToken);
}
