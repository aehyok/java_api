package com.sun.xxm.dto;

import lombok.Data;

@Data
public class CreateTestDto
{
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String Name;
}
