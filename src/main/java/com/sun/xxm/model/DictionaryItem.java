package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@TableName(value="dictionaryitem")
public class DictionaryItem {
    @Id
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value="code")
    private String code;

    @TableField(value="name")
    private String name;

    @TableField(value="display_order")
    private int displayOrder;

    @TableField(value="parent_id")
    private Long parentId;

    @TableField(value="big_picture")
    private String bigPicture;

    @TableField(value="small_picture")
    private String smallPicture;

    @TableField(value="is_deleted")
    private boolean isDeleted;

//    @TableField(exist = false)
//    private List<DictionaryItem> children;
}
