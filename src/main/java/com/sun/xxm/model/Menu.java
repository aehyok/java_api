package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName(value="menu")
public class Menu {
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    // 菜单类型
    @TableField(value="menu_type")
    private Integer menuType;

    // 父级菜单
    @TableField(value="parent_id")
    private Long parentId;

    // 菜单名称
    @TableField(value="title")
    private String title;

    // 路由名称
    @TableField(value="name")
    private String name;

    // 路由路径
    @TableField(value="path")
    private String path;

    // 组件路径
    @TableField(value="component")
    private String component;

    // 菜单排序
    @TableField(value="rank")
    private Integer rank;

    // 路由重定向
    @TableField(value="redirect")
    private String redirect;

    // 菜单图标
    @TableField(value="icon")
    private String icon;

    // 右侧图标
    @TableField(value="extraIcon")
    private String extraIcon;

    // 页面进场动画
    @TableField(value="extraIcon")
    private String enterTransition;

    // 页面离场动画
    @TableField(value="leaveTransition")
    private String leaveTransition;

    // 菜单激活
    @TableField(value="activePath")
    private String activePath;

    // 权限标识
    @TableField(value="auths")
    private String auths;

    // iframe 链接地址
    @TableField(value="frameSrc")
    private String frameSrc;

    // 加载动画
    @TableField(value="frameLoading")
    private boolean frameLoading;

    //是否缓存页面
    @TableField(value="keepAlive")
    private boolean keepAlive;

    // 是否允许标签页
    @TableField(value="hiddenTag")
    private boolean hiddenTag;

    // 是否固定标签页
    @TableField(value="fixedTag")
    private boolean fixedTag;
}
