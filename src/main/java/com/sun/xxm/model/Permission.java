package com.sun.xxm.model;

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
@Table("permission")
public class Permission extends BaseEntity {

    private Long roleId;

    private Long menuId;

    private Date createTime;
}
