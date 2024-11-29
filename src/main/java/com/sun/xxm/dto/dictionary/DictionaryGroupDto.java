package com.sun.xxm.dto.dictionary;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DictionaryGroupDto {
    private long id;

    private String name;

    private String code;

    private Integer order;

    private boolean isSystem;

    private String Remark;
}
