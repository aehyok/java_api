package com.sun.xxm.model;

import com.mybatisflex.annotation.KeyType;
import com.sun.xxm.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "keyconfig")
public class KeyConfig extends BaseEntity {
//    @jakarta.persistence.Id
//    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
//    private long id;

    private String label;

    private int displayOrder;

    private String dictionaryCode;

    private int remark;
}
