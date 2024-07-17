package com.sun.xxm.utils;

import com.mybatisflex.annotation.KeyType;
import jakarta.persistence.Entity;
import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class BaseEntity implements Serializable {
    @jakarta.persistence.Id
    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
    private Long id;
}
