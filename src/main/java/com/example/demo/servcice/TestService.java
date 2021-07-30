package com.example.demo.servcice;

import com.example.demo.mapper.TestMapper;
import com.example.demo.model.TestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TestService {
    @Autowired
    private TestMapper testMapper;
    //测试热部署
    public List<TestModel> getAll(){
        return testMapper.getAll();
    }

    public List<TestModel> getModelById(int id) {
        return testMapper.getById(id);
    }

    // TODO Mysql中的事务问题处理
    @Transactional(rollbackFor=Exception.class)
    public void operation(int id,String name){
        testMapper.insert(id,name);

        testMapper.delete(3);
        new Exception("ssssssssssss");
    }
}
