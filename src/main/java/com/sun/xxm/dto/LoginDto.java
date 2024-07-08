package com.sun.xxm.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    @Schema(name = "userName", description = "用户名")
    private String userName;

    @Schema(name = "password", description = "用户密码")
    private String password;

    /// <summary>
    /// 验证码
    /// </summary>
    @Schema(name = "captcha", description = "验证码")
    private String captcha;

    /// <summary>
    /// 验证码 Key
    /// </summary>
    private String captchaKey;
}
