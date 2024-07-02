package com.sun.xxm.service;

import com.sun.xxm.dto.TestDto;
import com.sun.xxm.model.Test;

import java.util.List;

public interface ITestService {
    public Test getTestById(long id);

    public List<TestDto> getAllTests();

    public void delete(long id);

    public void Post(Test test);
}
