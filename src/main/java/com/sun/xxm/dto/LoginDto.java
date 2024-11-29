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
    @Schema(name = "captchaValue", description = "验证码")
    private String captchaValue;

    /// <summary>
    /// 验证码 Key
    /// </summary>
    @Schema(name = "captchaKey", description = "验证码Key")
    private String captchaKey;

    private LoginType loginType = LoginType.Normal;
}