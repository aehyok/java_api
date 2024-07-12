package com.sun.xxm.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageResultModel extends ResultModel {
    /// <summary>
    /// 总数量
    /// </summary>
    private Long total;

    /// <summary>
    /// 当前页
    /// </summary>
    private Long page;

    /// <summary>
    /// 总页数
    /// </summary>
    private Long totalPage;

    /// <summary>
    /// 分页大小
    /// </summary>
    private Long limit;
}
