package com.sun.xxm.model;

import com.mybatisflex.annotation.Id;
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
@Table(value="file")
public class File {
    @jakarta.persistence.Id
    @Id(keyType = KeyType.Auto)
    private Long id;

    private String name;

    private Long size;

    private FileTypeEnum type;

    private String extension;

    private String url;

    private String path;

    private String content_type;

    private String hash;
}
