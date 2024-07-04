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
@TableName(value="article")
public class Article {
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    private String title;

    private String content;

    private String dictionaryCode;

    private String pictures;

}
