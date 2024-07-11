package com.sun.xxm.model;

import lombok.Getter;

@Getter
public enum StatusEnum {
    all(0),
    enable(1),
    disable(2);

    private Integer value;
    StatusEnum(int value) {
        this.value = value;
    }

    public static StatusEnum fromValue(int value) {
        for (StatusEnum  statusType : StatusEnum.values()) {
            if (statusType.getValue() == value) {
                return statusType;
            }
        }
        throw new IllegalArgumentException("无效的状态型值: " + value);
    }
}
