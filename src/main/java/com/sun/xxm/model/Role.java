package com.sun.xxm.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.sun.xxm.utils.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table("role")
public class Role extends BaseEntity {

    private String name;

    private String code;

    private String remark;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
