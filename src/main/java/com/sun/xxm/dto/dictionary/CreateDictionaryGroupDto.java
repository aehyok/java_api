package com.sun.xxm.dto.dictionary;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateDictionaryGroupDto {
    private String name;

    private String code;

    private Integer order;

    private String remark;
}
