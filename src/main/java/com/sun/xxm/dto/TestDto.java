package com.sun.xxm.dto;

import lombok.Data;

public class TestDto {
    public long Id;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String Name;
}
