package com.sun.xxm.dtoMapper;

import com.sun.xxm.dto.CreateDeptDto;
import com.sun.xxm.dto.DictionaryItemDto;
import com.sun.xxm.model.Dept;
import com.sun.xxm.model.DictionaryItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DeptDtoToEntityMapper {
    DeptDtoToEntityMapper instance = Mappers.getMapper(DeptDtoToEntityMapper.class);

    Dept toEntity (CreateDeptDto model);
}
