package com.sun.xxm.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.dto.RolePageQueryDto;
import com.sun.xxm.service.RoleMapper;
import com.sun.xxm.model.Role;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name="role", description = "角色管理")
@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleMapper roleMapper;

    @Operation(summary = "所有角色列表")
    @GetMapping("all")
    public List<Role> getList() {

        return roleMapper.selectAll();
    }

    @Operation(summary = "角色列表")
    @GetMapping()
    public Page<Role> getList(RolePageQueryDto model) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();

        if(!StrUtil.hasEmpty(model.getName())) {
            queryWrapper.like("name", model.getName());
        }

        if(!StrUtil.hasEmpty(model.getCode())) {
            queryWrapper.like("code", model.getCode());
        }

        if( model.getStatus() != null && model.getStatus() > 0) {
            queryWrapper.eq("status", model.getStatus());
        }

        return roleMapper.paginate(model.getPage(), model.getLimit(),queryWrapper);
    }

    @Operation(summary = "删除角色")
    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable Long id) {
        roleMapper.deleteById(id);
    }

    @Operation(summary = "新增角色")
    @PostMapping()
    public long postRole(@RequestBody  Role model) {
        model.setCreateTime(DateTime.now());
        var result = roleMapper.insert(model);
        return model.getId();
    }

    @Operation(summary = "修改角色")
    @PutMapping("{id}")
    public boolean putRole(@PathVariable Long id, @RequestBody  Role model) {
        var item = roleMapper.selectOneById(id);

        if(item != null) {
            model.setId(id);
            model.setUpdateTime(DateTime.now());
            roleMapper.update(model);
            return true;
        }
        else {
            throw new ApiException(ResultCodeEnum.FAILED, "当前角色不存在");
        }
    }
}
