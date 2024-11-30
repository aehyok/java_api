package com.sun.xxm.controller;

import cn.hutool.core.util.StrUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.dto.DictionaryItemDto;
import com.sun.xxm.dto.dictionary.*;
import com.sun.xxm.mapper.DictionaryGroupEntityToDtoMapper;
import com.sun.xxm.service.DictionaryGroupMapper;
import com.sun.xxm.service.DictionaryItemMapper;
import com.sun.xxm.model.DictionaryItem;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name="dictionary", description = "字典")
@RestController
@RequestMapping("/api/dictionary")
public class DictionaryController {

    private final DictionaryGroupMapper dictionaryGroupMapper;

    private final DictionaryItemMapper dictionaryItemMapper;


    public DictionaryController(DictionaryGroupMapper dictionaryGroupMapper, DictionaryItemMapper dictionaryItemMapper) {
        this.dictionaryGroupMapper = dictionaryGroupMapper;
        this.dictionaryItemMapper = dictionaryItemMapper;
    }

    @Operation( summary = "获取字典分组列表")
    @GetMapping("group")
    public List<DictionaryGroupDto> GetGroup(
            @Parameter(
                    description = "字典分组查询参数",
                    required = false
            )
            QueryDictionaryGroupDto model) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.orderBy("order", true);

        if(StrUtil.isNotEmpty(model.getKeyword())) {
            queryWrapper.like("name", model.getKeyword());
        }

        var list = this.dictionaryGroupMapper.selectAll();

//        var result = new ArrayList<DictionaryGroupDto>();
//        list.forEach((item -> {
//            var dto = DictionaryGroupEntityToDtoMapper.INSTANCE.toGroupDto(item);
//            result.add(dto);
//        }));
//        return result;
        var dtoList = DictionaryGroupEntityToDtoMapper.INSTANCE.toGroupDtos(list);
        return dtoList;
    }

    @Operation( summary = "通过分组Id获取分组详情")
    @GetMapping("group/{id}")
    public DictionaryGroupDto GetGroupById(
            @Parameter( name= "id", description = "字典分组Id")
            @PathVariable Long id) {
        var item = this.dictionaryGroupMapper.selectOneById(id);
        return DictionaryGroupEntityToDtoMapper.INSTANCE.toGroupDto(item);
    }

    @Operation(summary = "添加字典分组")
    @PostMapping("group")
    public void PostGroup(@RequestBody CreateDictionaryGroupDto model) {
        var entity = DictionaryGroupEntityToDtoMapper.INSTANCE.createGroupToEntity(model);
        this.dictionaryGroupMapper.insert(entity);
    }

    @Operation( summary = "修改字典分组")
    @PutMapping("group/{id}")
    public void PutGroup(@PathVariable Long id ,CreateDictionaryGroupDto model) {
        var entity = this.dictionaryGroupMapper.selectOneById(id);
        if(entity == null ) {
            throw new ApiException(ResultCodeEnum.FAILED, "你要修改的数据不存在");
        }

        model.setCode(entity.getCode());

        entity = DictionaryGroupEntityToDtoMapper.INSTANCE.createGroupToEntity(model);

        this.dictionaryGroupMapper.update(entity);
    }

    @Operation( summary = "删除字典分组")
    @DeleteMapping("group/{id}")
    public void DeleteGroup(@PathVariable Long id) {
        var entity = this.dictionaryGroupMapper.selectOneById(id);
        if(entity == null ) {
            throw new ApiException(ResultCodeEnum.FAILED, "你要删除的数据不存在");
        }
        this.dictionaryGroupMapper.deleteById(id);
    }

    @Operation( summary = "获取字典项列表")
    @GetMapping("{dictionaryGroupId}")
    public List<DictionaryItemDto> GetItemList(QueryDictionaryItemDto model) {
        if((model.getDictionaryGroupId() == null || model.getDictionaryGroupId() <= 0)
                && (StrUtil.isEmpty(model.getDictionaryGroupCode()))) {
            throw new ApiException(ResultCodeEnum.FAILED, "分组id 和 分组Key 至少选填一项");
        }

        if(model.getDictionaryGroupId() == null || model.getDictionaryGroupId() <= 0) {
            var group = this.dictionaryItemMapper.selectOneById(model.getDictionaryGroupId());
            if(group == null) {
                throw new ApiException(ResultCodeEnum.FAILED, "根据字典分组key [{model.GroupCode}] 未查询到任何分组信息");
            }

            model.setDictionaryGroupId(group.getDictionaryGroupId());
        }

        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("dictionary_group_id", model.getDictionaryGroupId());
        var list = this.dictionaryItemMapper.selectListByQuery(queryWrapper);
        return DictionaryGroupEntityToDtoMapper.INSTANCE.toItemDtos(list);
    }

    @Operation(summary = "获取字典项详情")
    @GetMapping("{id}")
    public DictionaryItemDto GetItemById(@PathVariable Long id) {
        var item = this.dictionaryItemMapper.selectOneById(id);
        return DictionaryGroupEntityToDtoMapper.INSTANCE.toItemDto(item);
    }

    @Operation( summary = "添加字典项")
    @PostMapping()
    public void PostItem(@RequestBody CreateDictionaryItemDto model) {
        var entity = DictionaryGroupEntityToDtoMapper.INSTANCE.createItemToEntity(model);
        if(model.getDictionaryGroupId() <= 0) {
            var group = this.dictionaryGroupMapper.selectOneById(model.getDictionaryGroupCode());
            if( group == null) {
                throw new ApiException(ResultCodeEnum.FAILED, "字典分组未找到");
            }

            entity.setDictionaryGroupId(group.getId());
            this.dictionaryItemMapper.insert(entity);
        }
    }

    @Operation( summary = "修改字典项")
    @PutMapping("{id}")
    public void PutItem(@PathVariable Long id, @RequestBody CreateDictionaryItemDto model) {
        var entity = this.dictionaryItemMapper.selectOneById(id);
        if(entity == null ) {
            throw  new ApiException(ResultCodeEnum.FAILED, "你要修改的数据不存在");
        }

        if(model.getDictionaryGroupId() <= 0) {
            var group = this.dictionaryGroupMapper.selectOneById(model.getDictionaryGroupCode());
            if( group == null ) {
                throw  new ApiException(ResultCodeEnum.FAILED, "字典分组未找到");
            }

            model.setDictionaryGroupId(group.getId());
        }

        entity = DictionaryGroupEntityToDtoMapper.INSTANCE.createItemToEntity(model);

        this.dictionaryItemMapper.update(entity);
    }


    @Operation( summary = "删除字典项")
    @DeleteMapping("{id}")
    public void DeleteItemById(@PathVariable Long id) {
        var entity = this.dictionaryItemMapper.selectOneById(id);

        if(entity == null) {
            throw new ApiException(ResultCodeEnum.FAILED, "您要删除的数据不存在");
        }

        this.dictionaryItemMapper.deleteById(id);
    }

    @Operation(summary = "获取字典项详情")
    @GetMapping("code/{code}")
    public DictionaryItem GetItemByCode(@PathVariable String code) {
        QueryWrapper queryWrapper = QueryWrapper.create().select();
        queryWrapper.eq("code", code);
        return this.dictionaryItemMapper.selectOneByQuery(queryWrapper);
    }

    @Operation( summary = "启用字典项")
    @PostMapping("enable/{id}")
    public void ItemEnable(@PathVariable Long id) {
        var entity = this.dictionaryItemMapper.selectOneById(id);

        if(entity == null) {
            throw new ApiException(ResultCodeEnum.FAILED, "您要启用的数据不存在");
        }

        entity.setEnable(true);

        this.dictionaryItemMapper.update(entity);
    }

    @Operation( summary = "禁用字典项")
    @PostMapping("disable/{id}")
    public void ItemDisable(@PathVariable Long id) {
        var entity = this.dictionaryItemMapper.selectOneById(id);

        if(entity == null) {
            throw new ApiException(ResultCodeEnum.FAILED, "您要禁用的数据不存在");
        }

        entity.setEnable(false);

        this.dictionaryItemMapper.update(entity);
    }
}
