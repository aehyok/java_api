package com.sun.xxm.controller;

import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.dto.DictionaryItemDto;
import com.sun.xxm.mapper.DictionaryItemEntityToDtoMapper;
import com.sun.xxm.service.DictionaryItemMapper;
import com.sun.xxm.model.DictionaryItem;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="dictionaryitem", description = "字典")
@RestController
@RequestMapping("/apis/dictionaryitem")
public class DictionaryItemController extends BaseController {

    @Autowired
    private DictionaryItemMapper dictionaryItemMapper;

    @Operation(summary = "获取所有字典项目")
    @GetMapping()
    public List<DictionaryItem> getList() {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("is_deleted", 0);
        queryWrapper.orderBy("parent_id", true);
        queryWrapper.orderBy("display_order", true);
        return dictionaryItemMapper.selectListByQuery(queryWrapper);
    }

    @Operation(summary = "根据Code获取下级项目字典列表")
    @GetMapping("{code}")
    public List<DictionaryItemDto> getList(String code) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("is_deleted", 0);
        queryWrapper.eq("code", code);

        var item = dictionaryItemMapper.selectOneByQuery(queryWrapper);
        if(item == null) {
            throw new ApiException(ResultCodeEnum.EMPTY);
        }
        else {
            queryWrapper.clear();
            queryWrapper.eq("is_deleted", 0);
            queryWrapper.eq("parent_id", item.getId());
            queryWrapper.orderBy("display_order");

            var parentList =  dictionaryItemMapper.selectListByQuery (queryWrapper);

            var dtoList = DictionaryItemEntityToDtoMapper.instance.toDtos(parentList);

            dtoList.forEach(child -> {
                System.out.println(child);
                queryWrapper.clear();
                queryWrapper.eq("is_deleted", 0);
                queryWrapper.eq("parent_id", child.getId());
                queryWrapper.orderBy("display_order");

                var childList =  dictionaryItemMapper.selectListByQuery(queryWrapper);

                var dtoChildList = DictionaryItemEntityToDtoMapper.instance.toDtos(childList);
                child.setChildren(dtoChildList);
            });

            return dtoList;
        }
    }
}
