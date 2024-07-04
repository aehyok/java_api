package com.sun.xxm.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class KeyValueDto {
    private String label;
    private String value;
    private Long id;
}
