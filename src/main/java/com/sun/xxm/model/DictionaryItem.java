package com.sun.xxm.model;

import com.mybatisflex.annotation.Table;
import com.sun.xxm.utils.BaseEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(value="dictionary_item")
public class DictionaryItem extends BaseEntity {

    private String name;

    private String code;

    private Integer order;

    private Long parentId;

    private Long dictionaryGroupId;

    private boolean isEnable;

    private String remark;

    private boolean isVisible;

    private String picture;
}
