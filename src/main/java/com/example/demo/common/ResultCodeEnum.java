package com.example.demo.common;

import lombok.Getter;
@Getter
public enum ResultCodeEnum {
    SUCCESS(true, 0000,"成功"),
    UNKNOWN_REASON(false, 0001, "未知错误"),
    BAD_SQL_GRAMMAR(false, 0002, "sql语法错误"),
    JSON_PARSE_ERROR(false, 0003, "json解析异常"),
    PARAM_ERROR(false, 0004, "参数不正确"),
    FILE_UPLOAD_ERROR(false, 0005, "文件上传错误"),
    EXCEL_DATA_IMPORT_ERROR(false, 0006, "Excel数据导入错误");

    private Boolean success; // 是否响应成功
    private Integer code;    // 响应的状态码
    private String message;  // 响应的消息

    ResultCodeEnum(Boolean success, Integer code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

}
