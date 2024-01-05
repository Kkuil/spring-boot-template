package com.kkuil.springboottemplate.interceptors;

import cn.hutool.extra.spring.SpringUtil;
import com.kkuil.biliclone.enums.common.TokenTypeEnum;
import com.kkuil.biliclone.enums.error.LoginErrorEnum;
import com.kkuil.springboottemplate.domain.bo.auth.TokenBO;
import com.kkuil.springboottemplate.domain.dto.request.RequestHolder;
import com.kkuil.springboottemplate.domain.dto.request.RequestInfoDTO;
import com.kkuil.springboottemplate.exception.UnAuthorizationException;
import com.kkuil.springboottemplate.service.UserService;
import com.kkuil.springboottemplate.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

import static com.kkuil.springboottemplate.constant.TokenConst.*;

/**
 * @Author kkuil
 * @Date 2023/07/29 20:00
 * @Description 登录拦截器
 */
@Component
@Slf4j(topic = "authInterceptor")
public class AuthInterceptor implements HandlerInterceptor {

    private static final UserService userService;

    static {
        userService = SpringUtil.getBean(UserService.class);
    }

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        log.info("request: {}", request.getRequestURL());
        log.info("token: {}", request.getHeader(TOKEN_KEY_IN_REQ_HEADER));
        String token = getToken(request);
        if (token.isEmpty()) {
            throw new UnAuthorizationException(String.valueOf(LoginErrorEnum.NON_LOGIN));
        }

        // 解析token
        Claims tokenClaims = JwtUtils.parse(token, System.getenv(USER_TOKEN_SECRET_ENV));
        Integer accountId = (Integer) tokenClaims.get(USER_TOKEN_ACCOUNT_ID_KEY);
        String tokenType = (String) tokenClaims.get(USER_TOKEN_TYPE_KEY);

        RequestInfoDTO requestInfoDTO = new RequestInfoDTO();
        requestInfoDTO.setAccountId(Long.valueOf(accountId));
        RequestHolder.set(requestInfoDTO);
        if (TokenTypeEnum.ACCESS_TOKEN.getDesc().equals(tokenType)) {
            // 放行即可
            return true;
        } else if (TokenTypeEnum.REFRESH_TOKEN.getDesc().equals(tokenType)) {
            // 刷新双token，存储到响应头中
            // 生成双token
            TokenBO tokenBO = userService.generateDoubleToken(Long.valueOf(accountId));
            // 保存响应体
            userService.saveTokenInHeader(response, tokenBO);
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        RequestHolder.remove();
    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader(TOKEN_KEY_IN_REQ_HEADER);
        return Optional.ofNullable(token)
                .filter(h -> h.startsWith(TOKEN_KEY_IN_HEADER_PREFIX))
                .map(h -> h.substring(TOKEN_KEY_IN_HEADER_PREFIX.length()))
                .orElse("");
    }
}
