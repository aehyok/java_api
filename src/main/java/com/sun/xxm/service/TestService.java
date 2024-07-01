package com.sun.xxm.service;

import com.sun.xxm.dao.TestRepository;
import com.sun.xxm.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public Test getTestById(long id) {
        var test = testRepository.findById(id);
        return testRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public List<Test> getAllTests() {
        return testRepository.findAll();
    }

    @Override
    public void delete(long id) {
        testRepository.deleteById(id);
    }
}
