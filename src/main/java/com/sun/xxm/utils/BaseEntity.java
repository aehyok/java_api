package com.sun.xxm.utils;

import com.mybatisflex.annotation.KeyType;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class BaseEntity {
    @jakarta.persistence.Id
    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
    private Long id;
}
