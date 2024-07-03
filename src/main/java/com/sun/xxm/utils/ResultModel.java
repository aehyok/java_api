package com.sun.xxm.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ResultModel<T> implements Serializable {

    private int Code;
    private String Message;
    private T Data;
    private long Timestamp;

    public ResultModel() {
        this.Timestamp = System.currentTimeMillis();
    }

    public ResultModel(T data) {
        this(ResultCodeEnum.SUCCESS, data);
    }

    public ResultModel(ResultCodeEnum resultCodeEnum, T data) {
        this.Code = resultCodeEnum.getCode();
        this.Message = resultCodeEnum.getMessage();
        this.Data = data;
    }
}
