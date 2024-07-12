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
@Table(value="role")
public class Role extends BaseEntity {
//    @jakarta.persistence.Id
//    @Id(keyType = KeyType.Auto)
//    private Long id;

    private String name;

    private String code;

    private String remark;

    private Integer status;

    private Date createTime;

    private Date updateTime;
}
