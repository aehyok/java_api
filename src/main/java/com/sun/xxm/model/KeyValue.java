package com.sun.xxm.model;

import com.mybatisflex.annotation.KeyType;
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
public class KeyValue {
    @jakarta.persistence.Id
    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
    private long id;

    private String value;

    private Long regionId;

    private Long keyValueId;


}
