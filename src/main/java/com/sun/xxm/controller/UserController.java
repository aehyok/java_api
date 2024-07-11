package com.sun.xxm.controller;

import com.sun.xxm.mapper.UserMapper;
import com.sun.xxm.model.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="user", description = "用户管理")
@RestController
@RequestMapping("/apis/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    public List<User> GetList() {
        return userMapper.selectList(null);
    }
}
