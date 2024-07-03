package com.sun.xxm.controller;

import com.sun.xxm.dto.LoginDto;
import com.sun.xxm.model.User;
import com.sun.xxm.service.ITestService;
import com.sun.xxm.service.IUserService;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Operation(summary = "通过Id获取测试数据")
    @PostMapping("login")
    public boolean Login(@RequestBody LoginDto model) {
        if(model.getUserName().isEmpty() || model.getPassword().isEmpty())
        {
            throw new ApiException(ResultCodeEnum.FAILED, "用户名或密码不能为空");
        }

        var user = userService.GetUserInfo(model.getUserName(), model.getPassword());
        return user != null;
    }
}
