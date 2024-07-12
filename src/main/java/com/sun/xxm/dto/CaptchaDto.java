package com.sun.xxm.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class CaptchaDto {
    /// <summary>
    /// 验证码
    /// </summary>
    private  String Captcha;

    /// <summary>
    /// 验证码 Key
    /// </summary>
    private String Key;

    /// <summary>
    /// 验证码过期时间
    /// </summary>
    private LocalDateTime ExpireTime;
}
