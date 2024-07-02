package com.sun.xxm.mapper;

import com.sun.xxm.dto.CreateTestDto;
import com.sun.xxm.model.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface  CreateTestMapperToEntity
{
    CreateTestMapperToEntity instance = Mappers.getMapper(CreateTestMapperToEntity.class);

    Test ToEntity(CreateTestDto dto);
}
