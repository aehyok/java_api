package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.model.UserModel;
import com.example.demo.servcice.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "事务测试" , httpMethod ="GET", notes = "事务测试")
    @ApiImplicitParams(@ApiImplicitParam(  name = "id",value = "用户ID",required = true,dataType = "int",paramType = "query"))
    @ApiResponse(response= UserModel.class, code = 200,  message = "接口返回对象参数")
    @ResponseBody
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public Result login(String account, String password) {
        Result r = null;
        List<UserModel> array = new ArrayList<UserModel>();
        array  = userService.Login(account, password);
        r = Result.ok().data("list",array);
        return r;
    }
}