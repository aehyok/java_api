package com.sun.xxm.controller;

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

    @GetMapping("/{id}")
    public Test getTestById(@PathVariable long  id)
    {
        return testService.getTestById(id);
    }

    @GetMapping()
    public List<Test> getList()
    {
        return testService.getAllTests();
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id)
    {
        testService.delete(id);
        return true;
    }
}
