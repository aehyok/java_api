package com.sun.xxm.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RolePageQueryDto extends PageQueryBaseDto {
    private String name;

    private String code;

    private Integer status;
}
