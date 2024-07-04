package com.sun.xxm.controller;

import com.sun.xxm.dto.KeyValueDto;
import com.sun.xxm.mapper.KeyValueMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.List;

@RestController
@RequestMapping("/keyvalue")
public class KeyValueController {

    @Autowired
    private KeyValueMapper keyValueMapper;

    @Operation(summary = "根据分类获取数据列表（前端定义好分类code就好）")
    @GetMapping("{regionId}/{code}")
    public List<KeyValueDto> getKeyValues(Long regionId, String code) {
        return keyValueMapper.getKeyValuesAsync(regionId, code);
    }
}
