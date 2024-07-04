package com.sun.xxm.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class DictionaryItemDto {
    private Long id;

    private String code;

    private String name;

    private Integer displayOrder;

    private Long parentId;

    private String bigPicture;

    private String smallPicture;

    private boolean isDeleted = false;

    private List<DictionaryItemDto> children = new ArrayList<DictionaryItemDto>();
}
