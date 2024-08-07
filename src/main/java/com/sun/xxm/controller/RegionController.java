package com.sun.xxm.controller;

import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.service.RegionMapper;
import com.sun.xxm.model.Region;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="region", description = "区域管理")
@RestController
@RequestMapping("/apis/region")
public class RegionController extends BaseController {

    @Autowired
    private RegionMapper regionMapper;

    @Operation(summary = "区域列表(包含切换的中心经纬度)")
    @GetMapping("/list")
    public List<Region> getRegions() {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("is_deleted", 0);
        queryWrapper.orderBy("display_order");

        return regionMapper.selectListByQuery(queryWrapper);
    }
}
