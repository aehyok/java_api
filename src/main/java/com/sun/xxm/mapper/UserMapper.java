package com.sun.xxm.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.xxm.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
