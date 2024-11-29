package com.sun.xxm.dto.dictionary;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Schema(description = "字典分组查询")
public class QueryDictionaryGroupDto {
    @Schema(description = "字典分组名称")
    private String keyword;
}
