package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@TableName(value="dept")
public class Dept {
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value="name")
    private String name;

    @TableField(value="sort")
    private int sort;

    @TableField(value="principal")
    private String principal;

    @TableField(value="phone")
    private String phone;

    @TableField(value="email")
    private String email;

    @TableField(value="status")
    private Integer status;

    @TableField(value="remark")
    private String remark;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "type")
    private Integer type;

    @TableField(value="parent_id")
    private Long parentId;

}
