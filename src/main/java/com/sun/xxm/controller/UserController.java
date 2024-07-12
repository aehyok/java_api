package com.sun.xxm.controller;

import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.dto.UserPageQueryDto;
import com.sun.xxm.mapper.UserMapper;
import com.sun.xxm.model.User;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="user", description = "用户管理")
@RestController
@RequestMapping("/apis/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

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

        if(model.getNickName() != null)
        {
            queryWrapper.like("nick_name", model.getNickName());
        }
        if(model.getPhone()!= null)
        {
            queryWrapper.like("phone", model.getPhone());
        }

        if(model.getStatus() > 0) {
            queryWrapper.eq("status", model.getStatus());
        }

        return userMapper.paginate(model.getPage(), model.getLimit(), queryWrapper);
    }
}
