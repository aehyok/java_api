package com.sun.xxm.mapper;

import com.sun.xxm.dto.DictionaryItemDto;
import com.sun.xxm.dto.dictionary.CreateDictionaryGroupDto;
import com.sun.xxm.dto.dictionary.CreateDictionaryItemDto;
import com.sun.xxm.dto.dictionary.DictionaryGroupDto;
import com.sun.xxm.model.DictionaryGroup;
import com.sun.xxm.model.DictionaryItem;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface DictionaryConvertMapper {
    public DictionaryConvertMapper INSTANCE = Mappers.getMapper(DictionaryConvertMapper.class);

    List<DictionaryGroupDto> toGroupDtos (List<DictionaryGroup> model);

    DictionaryGroupDto toGroupDto (DictionaryGroup model);

    List<DictionaryItemDto> toItemDtos (List<DictionaryItem> model);

    DictionaryItemDto toItemDto (DictionaryItem model);

    DictionaryGroup createGroupToEntity (CreateDictionaryGroupDto model);

    DictionaryItem createItemToEntity (CreateDictionaryItemDto model);
}
