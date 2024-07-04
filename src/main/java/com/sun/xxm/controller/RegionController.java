package com.sun.xxm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xxm.mapper.RegionMapper;
import com.sun.xxm.model.Region;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region")
public class RegionController extends BaseController {

    @Autowired
    private RegionMapper regionMapper;

    @Operation(summary = "区域列表(包含切换的中心经纬度)")
    @GetMapping("/list")
    public List<Region> getRegions() {
        QueryWrapper<Region> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", 0);
        queryWrapper.orderByAsc("display_order");

        return regionMapper.selectList(queryWrapper);
    }
}
