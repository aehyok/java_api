package com.sun.xxm.controller;

import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.dto.CreateMenuDto;
import com.sun.xxm.dto.menu.MenuTreeQueryDto;
import com.sun.xxm.mapper.MenuDtoToEntityMapper;
import com.sun.xxm.service.MenuMapper;
import com.sun.xxm.model.Menu;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="menu", description = "菜单管理")
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuMapper menuMapper;

    @Operation(summary = "菜单列表")
    @GetMapping()
    public List<Menu> getList() {
        return menuMapper.selectAll();
    }

    @Operation(summary = "菜单列表")
    @GetMapping("tree")
    public List<Menu> getTreeList(MenuTreeQueryDto model) {

        if (!model.getParentCode().isEmpty()) {
            QueryWrapper queryWrapper = QueryWrapper.create()
                    .where(Menu::getCode).eq(model.getParentCode())
                    .orderBy(Menu:: getRank).asc();

            var parent = menuMapper.selectOneByQuery(queryWrapper);
            if (parent == null) {
                throw new ApiException(ResultCodeEnum.FAILED, "未找到code：【"+ model.getParentCode() +"】 对应的菜单");
            }
            model.setParentId(parent.getParentId());
        }

        return menuMapper.selectAll();
    }

    @Operation(summary = "删除菜单")
    @DeleteMapping("{id}")
    public void deleteMenu(@PathVariable Long id) {
        menuMapper.deleteById(id);
    }

    @Operation(summary = "新增菜单")
    @PostMapping()
    public void postMenu(@RequestBody CreateMenuDto model) {
        var entity = MenuDtoToEntityMapper.instance.toEntity(model);
        menuMapper.insert(entity);
    }

    @Operation(summary = "修改菜单")
    @PutMapping("{id}")
    public void putMenu(@PathVariable Long id,@RequestBody CreateMenuDto model) {
        var item = menuMapper.selectOneById(id);

        if(item != null) {
            var entity = MenuDtoToEntityMapper.instance.toEntity(model);
            entity.setId(id);
            menuMapper.update(entity);
        }
        else {
            throw new ApiException(ResultCodeEnum.FAILED, "当前菜单不存在");
        }
    }
}
