package com.sun.xxm.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xxm.dto.DictionaryItemDto;
import com.sun.xxm.dtoMapper.DictionaryItemEntityToDtoMapper;
import com.sun.xxm.mapper.DictionaryItemMapper;
import com.sun.xxm.model.DictionaryItem;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/dictionary")
public class DictionaryItemController {

    @Autowired
    private DictionaryItemMapper dictionaryItemMapper;

    @Operation(summary = "获取所有字典项目")
    @GetMapping()
    public List<DictionaryItem> getList()
    {
        QueryWrapper<DictionaryItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", 0);
        queryWrapper.orderByAsc("parent_id", "display_order");

        return dictionaryItemMapper.selectList(queryWrapper);
    }


    @Operation(summary = "根据Code获取下级项目字典列表")
    @GetMapping("{code}")
    public List<DictionaryItemDto> getList(String code) {
        QueryWrapper<DictionaryItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_deleted", 0);
        queryWrapper.eq("code", code);
        var item =  dictionaryItemMapper.selectOne(queryWrapper);

        if(item == null) {
            throw new ApiException(ResultCodeEnum.EMPTY);
        }
        else {
            QueryWrapper<DictionaryItem> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.eq("is_deleted", 0);
            queryWrapper1.eq("parent_id", item.getId());
            queryWrapper1.orderByAsc("display_order");

            var parentList =  dictionaryItemMapper.selectList(queryWrapper1);

            var dtoList = DictionaryItemEntityToDtoMapper.instance.toDtos(parentList);

            dtoList.forEach(child -> {
                System.out.println(child);
                QueryWrapper<DictionaryItem> queryWrapper2 = new QueryWrapper<>();
                queryWrapper2.eq("is_deleted", 0);
                queryWrapper2.eq("parent_id", child.getId());
                queryWrapper2.orderByAsc("display_order");

                var childList =  dictionaryItemMapper.selectList(queryWrapper2);

                var dtoChildList = DictionaryItemEntityToDtoMapper.instance.toDtos(childList);
                child.setChildren(dtoChildList);
            });

            return dtoList;
        }
    }
}
