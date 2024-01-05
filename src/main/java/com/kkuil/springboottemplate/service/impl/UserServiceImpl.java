package com.kkuil.springboottemplate.service.impl;

import com.kkuil.springboottemplate.domain.bo.auth.TokenBO;
import com.kkuil.springboottemplate.service.IUserService;
import com.kkuil.springboottemplate.service.UserService;
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
public class UserServiceImpl implements UserService {
    /**
     * 双token生成
     *
     * @param accountId 账户ID
     * @return 双token
     */
    @Override
    public TokenBO generateDoubleToken(Long accountId) {
        String secret = System.getenv(USER_TOKEN_SECRET_ENV);
        Map<String, Object> tokenMap = new HashMap<>(1);
        tokenMap.put(USER_TOKEN_ACCOUNT_ID_KEY, accountId);
        tokenMap.put(USER_TOKEN_TYPE_KEY, com.kkuil.biliclone.enums.common.TokenTypeEnum.ACCESS_TOKEN.getDesc());

        // access_token
        String accessToken = JwtUtils.create(tokenMap, secret, USER_ACCESS_TOKEN_TTL);

        // refresh_token
        String refreshToken = JwtUtils.create(tokenMap, secret, USER_REFRESH_TOKEN_TTL);

        log.info("accessToken: {}", accessToken);
        log.info("refreshToken: {}", refreshToken);
        return TokenBO.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    /**
     * 保存响应头中...
     *
     * @param response    响应对象
     * @param doubleToken 双token对象
     */
    @Override
    public void saveTokenInHeader(HttpServletResponse response, TokenBO doubleToken) {
        response.setHeader(ACCESS_TOKEN_KEY_IN_RESP_HEADER, TOKEN_KEY_IN_HEADER_PREFIX + doubleToken.getAccessToken());
        response.setHeader(REFRESH_TOKEN_KEY_IN_RESP_HEADER, TOKEN_KEY_IN_HEADER_PREFIX + doubleToken.getRefreshToken());
    }
}
