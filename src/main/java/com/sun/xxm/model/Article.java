package com.sun.xxm.model;

import com.mybatisflex.annotation.KeyType;
import com.mybatisflex.annotation.Table;
import jakarta.persistence.Entity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(value="article")
public class Article {
    @jakarta.persistence.Id
    @com.mybatisflex.annotation.Id(keyType = KeyType.Auto)
    private Long id;

    private String title;

    private String content;

    private String dictionaryCode;

    private String pictures;

}
