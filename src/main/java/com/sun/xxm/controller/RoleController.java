package com.sun.xxm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xxm.dto.DeptPageQueryDto;
import com.sun.xxm.mapper.MenuMapper;
import com.sun.xxm.mapper.RoleMapper;
import com.sun.xxm.model.Menu;
import com.sun.xxm.model.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="role", description = "角色管理")
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;

    @Operation(summary = "菜单列表")
    @GetMapping()
    public List<Role> getList(DeptPageQueryDto model) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        return roleMapper.selectList(queryWrapper);
    }
}
