package com.sun.xxm.utils;

import lombok.Getter;

@Getter
public class ApiException  extends  RuntimeException{
    private final int code;
    private final String message;

    public ApiException(ResultCodeEnum resultCodeEnum){
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
    }

    public ApiException(ResultCodeEnum resultCodeEnum, String message){
        this.code = resultCodeEnum.getCode();
        this.message = message;
    }
}
