package com.sun.xxm.model;

import com.mybatisflex.annotation.KeyType;
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
@Table(name = "keyvalue")
public class KeyValue extends BaseEntity {
//    @jakarta.persistence.Id
//    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
//    private long id;

    private String value;

    private Long regionId;

    private Long keyValueId;


}
