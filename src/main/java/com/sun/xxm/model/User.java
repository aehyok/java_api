package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// @Builder // https://juejin.cn/post/7357957809071702050?searchId=20240704094536F54B142E45E0124F3D26#heading-9
//注解可以自动生成Builder模式的代码，Builder模式是一种创建对象的设计模式
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TableName(value="user")
public class User {
    //自增Id
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value="user_name")
    private String userName;

    @TableField(value="password")
    private String password;

    @TableField(value="nick_name")
    private String nickName;

    @TableField(value="phone")
    private String phone;

    @TableField(value="email")
    private String email;

    @TableField(value="sex")
    private Integer sex;

    @TableField(value="status")
    private Integer status;

    @TableField(value="remark")
    private String remark;

    @TableField(value="dept_id")
    private Long deptId;
}
