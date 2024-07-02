package com.sun.xxm.mapper;

import com.sun.xxm.dto.TestDto;
import com.sun.xxm.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapperToDto {
    TestMapperToDto instance = Mappers.getMapper(TestMapperToDto.class);

    TestDto toDto(Test test);
}

