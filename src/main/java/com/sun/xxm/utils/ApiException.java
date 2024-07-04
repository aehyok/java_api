package com.sun.xxm.utils;

import lombok.Getter;

@Getter
public class ApiException  extends  RuntimeException{
    private  int Code;
    private String Message;

    public ApiException(){
        this(ResultCodeEnum.FAILED);
    }

    public ApiException(ResultCodeEnum resultCodeEnum){
        this.Code = resultCodeEnum.getCode();
        this.Message = resultCodeEnum.getMessage();
    }

    public ApiException(ResultCodeEnum resultCodeEnum, String message){
        this.Code = resultCodeEnum.getCode();
        this.Message = message;
    }

    public ApiException()
}
