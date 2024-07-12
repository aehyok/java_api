package com.sun.xxm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageQueryBaseDto {

    private long page = 1;

    private long limit = 15;

    private String keyword = "";
}
