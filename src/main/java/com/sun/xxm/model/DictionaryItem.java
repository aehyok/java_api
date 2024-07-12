package com.sun.xxm.model;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import com.mybatisflex.annotation.KeyType;
import com.sun.xxm.utils.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(value="dictionaryitem")
public class DictionaryItem extends BaseEntity {
//    @jakarta.persistence.Id
//    @Id(keyType = KeyType.Auto)
//    private Long id;

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
