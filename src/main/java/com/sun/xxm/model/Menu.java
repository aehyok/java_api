package com.sun.xxm.model;

import com.mybatisflex.annotation.Table;
import com.sun.xxm.utils.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table("menu")
public class Menu extends BaseEntity {
    // 菜单类型
    private Integer menuType;

    // 父级菜单
    private Long parentId;

    // 菜单名称
    private String title;

    // 路由名称
    private String name;

    // 路由路径
    private String path;

    // 组件路径
    private String component;

    // 菜单排序
    private Integer rank;

    // 路由重定向
    private String redirect;

    // 菜单图标
    private String icon;

    // 右侧图标
    private String extraIcon;

    // 页面进场动画
    private String enterTransition;

    // 页面离场动画
    private String leaveTransition;

    // 菜单激活
    private String activePath;

    // 权限标识
    private String auths;

    // iframe 链接地址
    private String frameSrc;

    // 加载动画
    private boolean frameLoading;

    //是否缓存页面
    private boolean keepAlive;

    // 是否允许标签页
    private boolean hiddenTag;

    // 是否固定标签页
    private boolean fixedTag;
}
