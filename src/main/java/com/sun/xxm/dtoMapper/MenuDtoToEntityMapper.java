package com.sun.xxm.dtoMapper;

import com.sun.xxm.dto.CreateMenuDto;
import com.sun.xxm.model.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MenuDtoToEntityMapper {
    MenuDtoToEntityMapper instance = Mappers.getMapper(MenuDtoToEntityMapper.class);

    Menu toEntity (CreateMenuDto model);
}
