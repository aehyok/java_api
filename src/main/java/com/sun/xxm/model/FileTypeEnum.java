package com.sun.xxm.model;

import lombok.Getter;
import lombok.Setter;

/// <summary>
/// 文件类型
/// </summary>
@Getter
public enum FileTypeEnum {
    Other(9),
    Image(1),
    Doc(2),
    Video(3),
    Audio(4);

    private Integer value;
    FileTypeEnum(int value) {
        this.value = value;
    }

    public static FileTypeEnum fromValue(int value) {
        for (FileTypeEnum fileType : FileTypeEnum.values()) {
            if (fileType.getValue() == value) {
                return fileType;
            }
        }
        throw new IllegalArgumentException("无效的文件类型值: " + value);
    }
}