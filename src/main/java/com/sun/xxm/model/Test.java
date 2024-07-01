package com.sun.xxm.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Entity
@Table(name="Test")
public class Test {
    public long getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column(name="Name")
    private String Name;
}
