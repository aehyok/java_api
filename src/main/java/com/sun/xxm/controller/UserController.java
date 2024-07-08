package com.sun.xxm.controller;

import cn.hutool.cache.CacheUtil;
import cn.hutool.cache.impl.TimedCache;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xxm.dto.CaptchaDto;
import com.sun.xxm.dto.LoginDto;
import com.sun.xxm.mapper.UserMapper;
import com.sun.xxm.model.User;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.id.GUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Tag(name="user", description = "用户管理")
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {
    @Autowired
    private UserMapper userMapper;

    TimedCache<String, String> timedCache = CacheUtil.newTimedCache(1000 * 60 * 10);

    @Operation(summary = "通过用户名和密码登录", parameters = {
            @Parameter( name = "loginDto", description = "登录实体")
    })
    @PostMapping("login")
    public boolean Login(@RequestBody LoginDto model) {
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

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_name", model.getUserName());
        var item = userMapper.selectOne(queryWrapper);
        if (item != null) {
            if (Objects.equals(item.getPassword(), model.getPassword())) {
                return true;
            }
        }
        throw new ApiException(ResultCodeEnum.FAILED, "用户名或密码错误");
    }

    @Operation(summary = "生成验证码")
    @GetMapping("captcha")
    public CaptchaDto GetCaptcha() {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(150, 40, 4, 4);
        var dto = new CaptchaDto();

        dto.setCaptcha("data:image/jpeg;base64,"+captcha.getImageBase64());

        String  uuid = IdUtil.simpleUUID();
        dto.setKey(uuid);
        dto.setExpireTime(LocalDateTime.now());

        timedCache.put(uuid, captcha.getCode().toLowerCase());
        return dto;
    }

}
