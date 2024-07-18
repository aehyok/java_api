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
@Table("dept")
public class Dept extends BaseEntity {

    private String name;

    private int sort;

    private String principal;

    private String phone;

    private String email;

    private Integer status;

    private String remark;

    private Date createTime;

    private Integer type;

    private Long parentId;

}
