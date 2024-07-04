package com.sun.xxm.controller;

import com.sun.xxm.dto.TestDto;
import com.sun.xxm.model.DictionaryItem;
import com.sun.xxm.service.DictionaryItemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class DictionaryItemController {

    @Autowired
    private DictionaryItemService dictionaryItemService;

    @Operation(summary = "获取所有的测试数据")
    @GetMapping()
    public List<DictionaryItem> getList()
    {
        return dictionaryItemService.getDictionaryItems();
    }
}
