package com.sun.xxm.dto;

import cn.hutool.core.date.DateTime;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class TokenDto {
    private String accessToken;
    private String refreshToken;
    private Long userId;
    private DateTime expires;
    private String userName;
}
