package com.sun.xxm.service;

import com.sun.xxm.dao.UserRepository;
import com.sun.xxm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements  IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public User GetUserInfo(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }


}
