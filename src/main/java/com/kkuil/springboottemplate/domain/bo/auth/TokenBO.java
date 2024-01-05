package com.kkuil.springboottemplate.domain.bo.auth;

import lombok.Builder;
import lombok.Data;

/**
 * @Author Kkuil
 * @Date 2023/12/26 14:55
 * @Description token的业务实体
 */
@Data
@Builder
public class TokenBO {
    /**
     * access_token
     */
    private String accessToken;

    /**
     * refresh_token
     */
    private String refreshToken;
}
