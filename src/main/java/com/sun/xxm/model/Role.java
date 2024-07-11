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
@TableName(value="role")
public class Role {
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value="name")
    private String name;

    @TableField(value="code")
    private String code;

    @TableField(value="remark")
    private String remark;

    @TableField(value="status")
    private Integer status;
}
