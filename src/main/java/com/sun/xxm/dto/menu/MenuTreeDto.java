package com.sun.xxm.dto.menu;

import lombok.Data;

import java.util.List;

@Data
public class MenuTreeDto {
    private Long id;

    private String name;

    private List<MenuTreeDto> children;
}
