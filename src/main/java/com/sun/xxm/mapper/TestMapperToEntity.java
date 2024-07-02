package com.sun.xxm.mapper;

import com.sun.xxm.dto.CreateTestDto;
import com.sun.xxm.dto.TestDto;
import com.sun.xxm.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapperToEntity {
    TestMapperToEntity instance = Mappers.getMapper(TestMapperToEntity.class);

    Test ToEntity(TestDto dto);
}

