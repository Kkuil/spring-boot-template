package com.kkuil.springboottemplate.service.impl;

import com.kkuil.springboottemplate.service.IUserLoginService;
import com.kkuil.springboottemplate.utils.JwtUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static com.kkuil.springboottemplate.constant.TokenConst.*;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description UserServiceImpl
 */
@Service
@Slf4j(topic = "userService")
public class UserLoginLoginServiceImpl implements IUserLoginService {
    /**
     * token生成
     *
     * @param accountId 账户ID
     * @return token
     */
    @Override
    public String generateToken(Long accountId) {
        Map<String, Object> tokenMap = new HashMap<>(1);
        tokenMap.put(USER_TOKEN_ACCOUNT_ID_KEY, accountId);

        // token
        String token = JwtUtils.create(tokenMap, USER_TOKEN_SECRET, USER_TOKEN_TTL);

        log.info("token: {}", token);
        return token;
    }

    /**
     * 保存响应头中
     *
     * @param response 响应对象
     * @param token    token对象
     */
    @Override
    public void saveTokenInHeader(HttpServletResponse response, String token) {
        response.setHeader(TOKEN_KEY_IN_REQ_HEADER, TOKEN_KEY_IN_HEADER_PREFIX + token);
    }
}
