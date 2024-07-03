package com.sun.xxm.service;

import com.sun.xxm.dao.TestRepository;
import com.sun.xxm.dto.TestDto;
import com.sun.xxm.mapper.Test.TestMapperToDto;
import com.sun.xxm.model.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<TestDto> getAllTests() {
        var list = testRepository.findAll();

        List<TestDto> dtos = new ArrayList<>();
        list.forEach(item -> {
            var dto = TestMapperToDto.instance.toDto(item);
            dtos.add(dto);
        });

        return dtos;
    }

    @Override
    public void delete(long id) {
        testRepository.deleteById(id);
    }

    public void Post(Test test) {

        testRepository.save(test);
    }
}
