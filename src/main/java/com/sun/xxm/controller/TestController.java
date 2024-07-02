package com.sun.xxm.controller;

import com.sun.xxm.dto.CreateTestDto;
import com.sun.xxm.dto.TestDto;
import com.sun.xxm.mapper.CreateTestMapperToEntity;
import com.sun.xxm.mapper.TestMapperToEntity;
import com.sun.xxm.model.Test;
import com.sun.xxm.service.ITestService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/")
    @Operation(summary = "第一个接口 hello world")
    public String Hello()
    {
        return "Hello World";
    }

    @Autowired
    private ITestService testService;

    @Operation(summary = "通过Id获取测试数据")
    @GetMapping("/{id}")
    public Test getTestById(@PathVariable long  id)
    {
        return testService.getTestById(id);
    }

    @Operation(summary = "获取所有的测试数据")
    @GetMapping()
    public List<TestDto> getList()
    {
        return testService.getAllTests();
    }

    @Operation(summary = "通过Id删除测试数据")
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id)
    {
        testService.delete(id);
        return true;
    }

    @Operation(summary = "新增测试数据")
    @PostMapping()
    public boolean Post(@RequestBody CreateTestDto model)
    {
        Test entity = CreateTestMapperToEntity.instance.ToEntity(model);
        testService.Post(entity);
        return true;
    }

    @Operation(summary = "修改测试数据")
    @PutMapping("{id}")
    public boolean Put(long id,@RequestBody Test model)
    {
        var test = testService.getTestById(id);
        test.setName(model.getName());
        testService.Post(test);
        return true;
    }
}
