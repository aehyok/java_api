package com.sun.xxm.model;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.sun.xxm.utils.BaseEntity;
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
@Table(value="region")
public class Region {
    @jakarta.persistence.Id
    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
    private Long id;

    private String name;

    private Integer displayOrder;

    private Boolean isDeleted;

    private String centerPoint;
}
