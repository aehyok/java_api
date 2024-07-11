package com.sun.xxm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQueryBaseDto {

    private long pageNumber = 1;

    private long pageSize = 15;

    private String keyword = "";
}
