package com.example.demo.mapper;

import com.example.demo.model.TestModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface TestMapper {
    @Select("select * from tests")
    List<TestModel> getAll();
    @Select("select * from tests where ID = #{id}")
    List<TestModel> getById(int id);
}
