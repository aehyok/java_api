package com.sun.xxm.dto.menu;

import lombok.Data;

@Data
public class MenuTreeQueryDto {
    /// <summary>
    /// 父级 Id
    /// </summary>
    private long parentId;

    /// <summary>
    /// 父级编号
    /// </summary>
    private String parentCode;
}
