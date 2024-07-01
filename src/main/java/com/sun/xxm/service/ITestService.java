package com.sun.xxm.service;

import com.sun.xxm.model.Test;

import java.util.List;

public interface ITestService {
    public Test getTestById(long id);

    public List<Test> getAllTests();

    public void delete(long id);
}
