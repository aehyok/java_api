package com.example.demo.controller;

import com.example.demo.model.TestModel;
import com.example.demo.servcice.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value="/get")
    public List<TestModel> get(){
        return testService.getllAll();
    }

    @RequestMapping(value="/get/{id}")
    public List<TestModel> getModelById(@PathVariable int id)
    {
        return testService.getModelById(id);
    }
}
