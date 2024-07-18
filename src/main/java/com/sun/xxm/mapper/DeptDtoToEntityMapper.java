package com.sun.xxm.mapper;

import com.sun.xxm.dto.CreateDeptDto;
import com.sun.xxm.model.Dept;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeptDtoToEntityMapper {
    DeptDtoToEntityMapper instance = Mappers.getMapper(DeptDtoToEntityMapper.class);

    Dept toEntity (CreateDeptDto model);
}
