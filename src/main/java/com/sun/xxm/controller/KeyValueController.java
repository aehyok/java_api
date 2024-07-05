package com.sun.xxm.controller;

import com.sun.xxm.dto.KeyValueDto;
import com.sun.xxm.dto.NameValueDto;
import com.sun.xxm.mapper.KeyValueMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.List;

@Tag(name="keyvalue", description = "键值对管理")
@RestController
@RequestMapping("/api/keyvalue")
public class KeyValueController {

    @Autowired
    private KeyValueMapper keyValueMapper;

    @Operation(summary = "根据分类获取数据列表（前端定义好分类code就好）")
    @GetMapping("/get/{regionId}/{code}")
    public List<KeyValueDto> getKeyValues(Long regionId, String code) {
        return keyValueMapper.getKeyValues(regionId, code);
    }

    @Operation(summary = "根据分类获取数据列表（前端定义好分类code就好）")
    @GetMapping("/gets/{regionId}/{code}")
    public List<NameValueDto> GetMiddleKeyValues(Long regionId) {
        var codes = new String[]{"charts-middle", "charts-left-1"};
        return keyValueMapper.getKeyValuesByCodes(regionId, codes);
    }
}
