package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "keyconfig")
public class KeyConfig {
    @jakarta.persistence.Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @TableField(value="code")
    private String label;

    @TableField(value="display_order")
    private int displayOrder;

    @TableField(value="dictionary_code")
    private String dictionaryCode;

    @TableField(value="remark")
    private int remark;
}
