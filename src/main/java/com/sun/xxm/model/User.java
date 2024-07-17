package com.sun.xxm.model;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.sun.xxm.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

// @Builder // https://juejin.cn/post/7357957809071702050?searchId=20240704094536F54B142E45E0124F3D26#heading-9
//注解可以自动生成Builder模式的代码，Builder模式是一种创建对象的设计模式
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(value="user")
public class User extends BaseEntity {
    //自增Id
//    @jakarta.persistence.Id
//    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
//    private Long id;

    private String userName;

    private String password;

    private String nickName;

    private String phone;

    private String email;

    private Integer sex;

    private Integer status;

    private String remark;

    private Long deptId;

    private Date createTime;

    private Date updateTime;
}
