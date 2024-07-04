package com.sun.xxm.dao;

import com.sun.xxm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {
    public User findByUserNameAndPassword(String userName, String password);

//    public User findByUserNameOrPhoneOrEmail(String userName, String phone, String email);
}
