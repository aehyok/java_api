package com.sun.xxm.controller;

import com.baomidou.mybatisplus.core.conditions.query.Query;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.xxm.mapper.ArticleMapper;
import com.sun.xxm.mapper.DictionaryItemMapper;
import com.sun.xxm.model.Article;
import com.sun.xxm.model.DictionaryItem;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    private DictionaryItemMapper dictionaryItemMapper;

    @Operation(summary = "通过字典项code获取文章内容")
    @GetMapping("{code}")
    public Article getArticles(String code) {
        QueryWrapper<Article> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dictionary_code", code);
        return articleMapper.selectOne(queryWrapper);
    }

    @Operation(summary = "新增文章")
    @PostMapping()
    public Article postArticle(@RequestBody Article article) {
        if(article.getDictionaryCode().isEmpty())
        {
            throw new ApiException(ResultCodeEnum.FAILED, "请传入字典项");
        }

        QueryWrapper<DictionaryItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dictionary_code", article.getDictionaryCode());
        var item = dictionaryItemMapper.selectOne(queryWrapper);
        if(item == null){
            throw new ApiException(ResultCodeEnum.FAILED, "请传入正确的字典项");
        }

        articleMapper.insert(article);
        return article;
    }

    @Operation(summary = "修改文章")
    @PutMapping()
    public Article putArticle(@RequestBody Article article) {
        if(article.getDictionaryCode().isEmpty())
        {
            throw new ApiException(ResultCodeEnum.FAILED, "请传入字典项");
        }

        QueryWrapper<DictionaryItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dictionary_code", article.getDictionaryCode());
        var item = dictionaryItemMapper.selectOne(queryWrapper);
        if(item == null){
            throw new ApiException(ResultCodeEnum.FAILED, "请传入正确的字典项");
        }

        QueryWrapper<Article> articleQueryWrapper = new QueryWrapper<>();
        articleQueryWrapper.eq("id", article.getId());
        var selectArticle  = articleMapper.selectOne(articleQueryWrapper);
        selectArticle.setContent(article.getContent());
        selectArticle.setTitle(article.getTitle());

        articleMapper.update(article,articleQueryWrapper);
        return article;
    }
}
