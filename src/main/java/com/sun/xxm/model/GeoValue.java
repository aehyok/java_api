package com.sun.xxm.model;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
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
@Table(value="geovalue")
public class GeoValue {
    @jakarta.persistence.Id
    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
    private Long id;

    private String code;

    private String name;

    private int displayOrder;

    private Long parentId;

    private String bigPicture;

    private String smallPicture;

    private boolean isDeleted;

//    @TableField(exist = false)
//    private List<DictionaryItem> children;
}
