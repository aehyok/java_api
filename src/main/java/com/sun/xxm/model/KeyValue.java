package com.sun.xxm.model;

import com.baomidou.mybatisplus.annotation.TableField;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "keyvalue")
public class KeyValue {
    @jakarta.persistence.Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @TableField(value="value")
    private String value;

    @TableField(value="region_id")
    private Long regionId;

    @TableField(value="key_config_id")
    private Long keyValueId;


}
