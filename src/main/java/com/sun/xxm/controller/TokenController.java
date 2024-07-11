package com.sun.xxm.controller;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.util.IdUtil;
import cn.hutool.jwt.JWTUtil;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.dto.CaptchaDto;
import com.sun.xxm.dto.LoginDto;
import com.sun.xxm.dto.TokenDto;
import com.sun.xxm.mapper.UserMapper;
import com.sun.xxm.model.User;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Tag(name="token", description = "Token管理")
@RestController
@RequestMapping("/apis/token")
public class TokenController extends BaseController {
    @Autowired
    private UserMapper userMapper;

    TimedCache<String, String> timedCache = CacheUtil.newTimedCache(1000 * 60 * 10);

    @Operation(summary = "通过用户名和密码登录", parameters = {
            @Parameter( name = "loginDto", description = "登录实体")
    })
    @PostMapping("login")
    public TokenDto Login(@RequestBody LoginDto model) {
        if(model.getUserName().isEmpty() || model.getPassword().isEmpty())
        {
            throw new ApiException(ResultCodeEnum.FAILED, "用户名或密码不能为空");
        }

        if(model.getCaptchaKey().isEmpty()) {
            throw  new ApiException(ResultCodeEnum.FAILED, "请传入验证码key");
        }

        String captcha = timedCache.get(model.getCaptchaKey(), false);

        if(!model.getCaptcha().toLowerCase().equals(captcha)) {
            throw  new ApiException(ResultCodeEnum.FAILED, "验证码错误");
        }

        Map<String, Object> condition = Map.of("user_name", model.getUserName());

        var item = userMapper.selectOneByMap(condition);
        if (item != null) {
            if (Objects.equals(item.getPassword(), model.getPassword())) {

                Map<String, Object> map = new HashMap<String, Object>() {
                    private static final long serialVersionUID = 1L; {
                        put("uid", item.getId());
                        // 15天的时间
                        put("expire_time", System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 15);
                    }
                };

                var token = JWTUtil.createToken(map, "xxm".getBytes());
                var dto = new TokenDto();
                dto.setAccessToken(token);
                dto.setUserId(item.getId());
                dto.setUserName(item.getUserName());
                return dto;
            }
        }
        throw new ApiException(ResultCodeEnum.FAILED, "用户名或密码错误");
    }

    @Operation(summary = "生成验证码")
    @GetMapping("captcha")
    public CaptchaDto GetCaptcha() {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(120, 40, 4, 1);
        var dto = new CaptchaDto();

        dto.setCaptcha("data:image/jpeg;base64,"+captcha.getImageBase64());

        String  uuid = IdUtil.simpleUUID();
        dto.setKey(uuid);
        dto.setExpireTime(LocalDateTime.now());

        timedCache.put(uuid, captcha.getCode().toLowerCase());
        return dto;
    }
}
