package com.sun.xxm.service;


import com.mybatisflex.core.BaseMapper;
import com.sun.xxm.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
