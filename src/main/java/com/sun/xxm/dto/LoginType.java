package com.sun.xxm.dto;

public enum LoginType {
    Normal(1),
    Swagger(2);

    private final int code;

    LoginType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    // 根据code获取枚举值的静态方法
    public static LoginType fromCode(int code) {
        for (LoginType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid user type code: " + code);
    }
}