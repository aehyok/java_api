package com.example.demo.servcice;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;

    public List<TestModel> getAll(){
        return testMapper.getAll();
    }

    public List<TestModel> getModelById(int id) {
        return testMapper.getById(id);
    }

    public void operation(int id,String name){
        testMapper.delete(1);
        testMapper.insert(id,name);
    }
}
