package com.sun.xxm.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CreateDeptDto {
    private String name;

    private int sort;

    private String principal;

    private String phone;

    private String email;

    private Integer status;

    private String remark;

    private Date createTime;

    private Integer type;

    private Long parentId;
}
