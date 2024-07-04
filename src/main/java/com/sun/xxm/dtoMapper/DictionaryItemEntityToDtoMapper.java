package com.sun.xxm.dtoMapper;

import com.sun.xxm.dto.DictionaryItemDto;
import com.sun.xxm.model.DictionaryItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DictionaryItemEntityToDtoMapper {

    DictionaryItemEntityToDtoMapper instance = Mappers.getMapper(DictionaryItemEntityToDtoMapper.class);

    DictionaryItemDto toDto (DictionaryItem model);

    List<DictionaryItemDto> toDtos (List<DictionaryItem> model);
}
