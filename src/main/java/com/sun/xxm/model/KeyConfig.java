package com.sun.xxm.model;

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

    @Column(name="label")
    private String label;

    @Column(name="display_order")
    private int displayOrder;

    @Column(name="dictionary_code")
    private String dictionaryCode;
    private int remark;
}
