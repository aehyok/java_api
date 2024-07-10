package com.sun.xxm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQueryBaseDto {

    private Integer limit = 15;

    private Integer page = 1;

    private String keyword = "";
}
