package com.example.demo.mapper;

import com.example.demo.model.UserModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select * from user")
    List<UserModel> getAll();

    @Select("select * from user where account = #{account} and  password = #{password}")
    List<UserModel> Login(String account, String password);
}