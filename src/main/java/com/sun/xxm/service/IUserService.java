package com.sun.xxm.service;

import com.sun.xxm.model.User;

public interface IUserService {
    public User getUser(long id);

    public User GetUserInfo(String userName, String password);
}
