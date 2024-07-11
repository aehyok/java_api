package com.sun.xxm.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xxm.dto.DeptPageQueryDto;
import com.sun.xxm.mapper.DeptMapper;
import com.sun.xxm.model.Article;
import com.sun.xxm.model.Dept;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="dept", description = "部门管理")
@RestController
@RequestMapping("/apis/dept")
public class DeptController {
    @Autowired
    private DeptMapper deptMapper;

    @Operation(summary = "部门列表")
    @GetMapping("")
    public List<Dept> getDeptList(DeptPageQueryDto model) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        return deptMapper.selectList(queryWrapper);
    }

    @Operation(summary = "删除部门")
    @DeleteMapping("{id}")
    public void deleteDept(@PathVariable Long id) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);
        deptMapper.delete(queryWrapper);
    }

    @Operation(summary = "新增部门")
    @PostMapping()
    public void postDept(@RequestBody Dept model) {
        model.setCreateTime(DateTime.now());
        deptMapper.insert(model);
    }

    @Operation(summary = "修改部门")
    @PutMapping("{id}")
    public boolean putDept(@PathVariable Long id, @RequestBody Dept model) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", id);

        var item = deptMapper.selectOne(queryWrapper);
        model.setId(id);

        if(item != null) {
            deptMapper.update(model,queryWrapper);
            return true;
        }
        else {
            throw new ApiException(ResultCodeEnum.FAILED, "当前部门不存在");
        }
    }
}
