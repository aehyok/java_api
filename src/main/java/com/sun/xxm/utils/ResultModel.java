package com.sun.xxm.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class ResultModel<T> implements Serializable {

    private int code;
    private String message;
    private T data;
    private long timestamp;

    public ResultModel() {
        this.timestamp = System.currentTimeMillis();
    }

    public ResultModel(T data) {
        this(ResultCodeEnum.SUCCESS, data);
        this.timestamp = System.currentTimeMillis();
    }

    public ResultModel(ResultCodeEnum resultCodeEnum, T data) {
        this.code = resultCodeEnum.getCode();
        this.message = resultCodeEnum.getMessage();
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }
}
