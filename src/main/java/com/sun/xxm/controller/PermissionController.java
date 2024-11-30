package com.sun.xxm.controller;

import cn.hutool.core.date.DateTime;
import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.service.PermissionMapper;
import com.sun.xxm.model.Permission;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Tag(name="permission", description = "权限管理")
@RestController
@RequestMapping("/api/permission")
public class PermissionController {
    @Autowired
    private PermissionMapper permissionMapper;

    @Operation(summary = "权限列表")
    @GetMapping("{roleId}")
    public List<Long> getList(@PathVariable Long roleId) {
        if(roleId == null) {
            throw new ApiException(ResultCodeEnum.FAILED, "角色Id不能为空");
        }

        QueryWrapper queryWrapper = QueryWrapper.create().select("menu_id");
        queryWrapper.ge("role_id",roleId);

        return permissionMapper.selectListByQuery(queryWrapper).stream().map(Permission:: getMenuId).collect(Collectors.toUnmodifiableList());
    }

    @Operation(summary = "保存角色权限列表")
    @PostMapping("{roleId}")
    public void postPermission(@PathVariable Long roleId, @RequestBody List<Long> permissionList) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("role_id",roleId);
        permissionMapper.deleteByQuery(queryWrapper);

        var list = new ArrayList<Permission>();
        permissionList.forEach(item -> {
            var dto = new Permission();
            dto.setRoleId(roleId);
            dto.setMenuId(item);
            dto.setCreateTime(DateTime.now());

            list.add(dto);
        });

        permissionMapper.insertBatch(list);
    }
}
