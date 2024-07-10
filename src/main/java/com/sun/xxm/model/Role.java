package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.IdType;
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

    private String name;

    private String code;

    private String remark;

    private Integer status;
}
