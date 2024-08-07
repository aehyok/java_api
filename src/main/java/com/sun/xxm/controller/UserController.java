package com.sun.xxm.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.dto.UserPageQueryDto;
import com.sun.xxm.service.UserMapper;
import com.sun.xxm.service.UserRoleMapper;
import com.sun.xxm.model.User;
import com.sun.xxm.model.UserRole;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name="user", description = "用户管理")
@RestController
@RequestMapping("/apis/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Operation(summary = "用户列表")
    @GetMapping()
    public Page<User> GetList(UserPageQueryDto model) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        if(model.getDeptId() != null)
        {
            queryWrapper.eq("dept_id", model.getDeptId());
        }
        else {
            throw new ApiException(ResultCodeEnum.FAILED, "部门参数不能为空");
        }

        if(!StrUtil.hasEmpty(model.getNickName()))
        {
            queryWrapper.like("nick_name", model.getNickName());
        }
        if(!StrUtil.hasEmpty(model.getPhone()))
        {
            queryWrapper.like("phone", model.getPhone());
        }

        if(model.getStatus() != null && model.getStatus() > 0) {
            queryWrapper.eq("status", model.getStatus());
        }

        return userMapper.paginateWithRelations(model.getPage(), model.getLimit(), queryWrapper);
    }

    @Operation(summary = "删除用户")
    @DeleteMapping("{id}")
    public void deleteRole(@PathVariable Long id) {
        userMapper.deleteById(id);
    }

    @Operation(summary = "新增角色")
    @PostMapping()
    public long postRole(@RequestBody User model) {
        model.setCreateTime(DateTime.now());
        var result = userMapper.insert(model);
        return model.getId();
    }

    @Operation(summary = "修改角色")
    @PutMapping("{id}")
    public boolean putRole(@PathVariable Long id, @RequestBody  User model) {
        var item = userMapper.selectOneById(id);

        if(item != null) {
            model.setId(id);
            model.setUpdateTime(DateTime.now());
            userMapper.update(model);
            return true;
        }
        else {
            throw new ApiException(ResultCodeEnum.FAILED, "当前用户不存在");
        }
    }

    @Operation(summary = "获取当前用户角色列表")
    @GetMapping("/role/{userId}")
    public List<UserRole> postUserRole(@PathVariable Long userId) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("user_id", userId);
        return userRoleMapper.selectListByQuery(queryWrapper);
    }


    @Operation(summary = "用户角色分配")
    @PostMapping("/role/{userId}")
    @Transactional
    public void postUserRole(@PathVariable Long userId, @RequestBody List<Long> roleIds) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("user_id", userId);
        userRoleMapper.deleteByQuery(queryWrapper);

        var list = new ArrayList<UserRole>();
        roleIds.forEach(item -> {
            UserRole ur = new UserRole();
            ur.setUserId(userId);
            ur.setRoleId(item);
            list.add(ur);
        });

//        throw new ApiException(ResultCodeEnum.FAILED, "事务出错");
        userRoleMapper.insertBatch(list);
    }
}
