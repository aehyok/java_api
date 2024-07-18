package com.sun.xxm.model;

import com.mybatisflex.annotation.Table;
import com.sun.xxm.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table("key_config")
public class KeyConfig extends BaseEntity {

    private String label;

    private int displayOrder;

    private String dictionaryCode;

    private int remark;
}
