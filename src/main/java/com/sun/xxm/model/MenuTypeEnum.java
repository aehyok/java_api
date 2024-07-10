package com.sun.xxm.model;

import lombok.Getter;

@Getter
public enum MenuTypeEnum {
    menu(0),
    iframe(1),
    Doc(2),
    Video(3),
    Audio(4);

    private Integer value;
    MenuTypeEnum(int value) {
        this.value = value;
    }

    public static MenuTypeEnum fromValue(int value) {
        for (MenuTypeEnum  menuType : MenuTypeEnum.values()) {
            if (menuType.getValue() == value) {
                return menuType;
            }
        }
        throw new IllegalArgumentException("无效的菜单类型值: " + value);
    }
}
