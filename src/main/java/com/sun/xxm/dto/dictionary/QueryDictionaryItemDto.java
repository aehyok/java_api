package com.sun.xxm.dto.dictionary;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryDictionaryItemDto {

    private String keyword;

    private Long dictionaryGroupId;

    private String dictionaryGroupCode;
}
