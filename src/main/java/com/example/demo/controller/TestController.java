package com.example.demo.controller;

import com.example.demo.model.TestModel;
import com.example.demo.servcice.TestService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
@Api(description = "测试")
public class TestController {
    @Autowired
    private TestService testService;

    @ApiOperation(value = "查询所有用户" , httpMethod ="GET", notes = "查询所有用户")
    //@ApiImplicitParams(@ApiImplicitParam(  name = "id",value = "用户ID",required = true,dataType = "int",paramType = "query"))
    @ApiResponse(response=TestModel.class, code = 200,  message = "接口返回对象参数")
    @ResponseBody
    //@RequestMapping(value="/get",method= RequestMethod.GET)  与下面写法一致  @GetMapping(value = "/get")
    @GetMapping(value = "/get")
    public List<TestModel> get(){
        return testService.getAll();
    }

    @ApiOperation(value = "查询用户" , httpMethod ="GET", notes = "根据Id查询用户")
    @ApiImplicitParams(@ApiImplicitParam(  name = "id",value = "用户ID",required = true,dataType = "int",paramType = "query"))
    @ApiResponse(response=TestModel.class, code = 200,  message = "接口返回对象参数")
    @ResponseBody
    @RequestMapping(value="/get/{id}",method= RequestMethod.GET)
    public List<TestModel> getModelById(@PathVariable int id) {
        return testService.getModelById(id);
    }


    @ApiOperation(value = "事务测试" , httpMethod ="GET", notes = "事务测试")
    @ApiImplicitParams(@ApiImplicitParam(  name = "id",value = "用户ID",required = true,dataType = "int",paramType = "query"))
    @ApiResponse(response=TestModel.class, code = 200,  message = "接口返回对象参数")
    @ResponseBody
    @RequestMapping(value="/operation",method= RequestMethod.GET)
    public  void operation(int id,String name) {
         testService.operation(id,name);
    }
}
