package com.sun.xxm.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "dictionaryitem")
public class DictionaryItem {
    @jakarta.persistence.Id
    @Column(name="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

    @Column(name="display_order")
    private int displayOrder;

    @Column(name="parent_id")
    private long parentId;

    @Column(name="big_picture")
    private String bigPicture;

    @Column(name="small_picture")
    private String smallPicture;

    @Column(name="is_deleted")
    private boolean isDeleted = false;
}
