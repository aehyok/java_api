package com.sun.xxm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPageQueryDto extends PageQueryBaseDto {
    private String nickName;

    private String phone;

    private Integer status;

    private Long deptId;
}
