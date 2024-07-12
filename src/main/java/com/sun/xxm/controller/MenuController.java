package com.sun.xxm.controller;

import com.sun.xxm.dto.DeptPageQueryDto;
import com.sun.xxm.mapper.MenuMapper;
import com.sun.xxm.model.Menu;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="menu", description = "菜单管理")
@RestController
@RequestMapping("/apis/menu")
public class MenuController {
    @Autowired
    private MenuMapper menuMapper;

    @Operation(summary = "菜单列表")
    @GetMapping()
    public List<Menu> getList(DeptPageQueryDto model) {
        return menuMapper.selectAll();
    }
}
