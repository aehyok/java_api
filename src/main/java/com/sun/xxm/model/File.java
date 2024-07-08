package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@TableName(value="file")
public class File {
    @Id
    @TableId(type = IdType.AUTO)
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
