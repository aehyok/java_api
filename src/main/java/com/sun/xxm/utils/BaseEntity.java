package com.sun.xxm.utils;

import com.mybatisflex.annotation.KeyType;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Getter
@Setter
public class BaseEntity implements Serializable {
    @jakarta.persistence.Id
    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
    private Long id;

    private boolean isDeleted;

    private Date createTime;

    private Date updateTime;
}
