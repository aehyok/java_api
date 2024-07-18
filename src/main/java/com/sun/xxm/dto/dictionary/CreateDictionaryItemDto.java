package com.sun.xxm.dto.dictionary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDictionaryItemDto {
    private String name;

    private String code;

    private Integer order;

    private Long parentId;

    private Long dictionaryGroupId;

    private String dictionaryGroupCode;

    private boolean isVisible;

    private String Remark;
}
