package com.sun.xxm.utils;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "请求处理成功"),
    EMPTY(405, "数据不存在"),
    Unauthorized(401, "请先登录"),
    FAILED(-1, "接口错误"),
    SERVER_ERROR(500, "服务器出现问题，请稍后重试");

    private int Code;
    private String Message;

    ResultCodeEnum(int code, String message) {
        this.Code = code;
        this.Message = message;
    }
}

