package com.example.demo.mapper;

import com.example.demo.model.TestModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("insert into tests(id,name) values(#{id},#{name})")
    boolean insert(int id,String name);

    @Delete("delete from tests where ID=#{id}")
    void  delete(int id);
}
