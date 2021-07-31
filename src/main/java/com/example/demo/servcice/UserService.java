package com.example.demo.servcice;


import com.example.demo.mapper.TestMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.TestModel;
import com.example.demo.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserModel> Login(String account, String password) {
        return userMapper.Login(account, password);
    }

}

