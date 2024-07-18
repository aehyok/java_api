package com.sun.xxm.controller;

import com.mybatisflex.core.query.QueryWrapper;
import com.sun.xxm.service.ArticleMapper;
import com.sun.xxm.service.DictionaryItemMapper;
import com.sun.xxm.model.Article;
import com.sun.xxm.utils.ApiException;
import com.sun.xxm.utils.ResultCodeEnum;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name="article", description = "文章管理")
@RestController
@RequestMapping("/apis/article")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    private DictionaryItemMapper dictionaryItemMapper;

    @Operation(summary = "通过字典项code获取文章内容")
    @GetMapping("{code}")
    public Article getArticles(String code) {
        QueryWrapper query = QueryWrapper.create().select().ge("code", code);

        return articleMapper.selectOneByQuery(query);
    }

    @Operation(summary = "新增文章")
    @PostMapping()
    public Article postArticle(@RequestBody Article article) {
        if(article.getDictionaryCode().isEmpty())
        {
            throw new ApiException(ResultCodeEnum.FAILED, "请传入字典项");
        }

        QueryWrapper query = QueryWrapper.create().select().ge("dictionary_code", article.getDictionaryCode());
        var item = dictionaryItemMapper.selectOneByQuery(query);
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

        QueryWrapper query = QueryWrapper.create().select().ge("dictionary_code", article.getDictionaryCode());
        var item = dictionaryItemMapper.selectOneByQuery(query);
        if(item == null){
            throw new ApiException(ResultCodeEnum.FAILED, "请传入正确的字典项");
        }

        var selectArticle = articleMapper.selectOneById(article.getId());
        selectArticle.setContent(article.getContent());
        selectArticle.setTitle(article.getTitle());

        articleMapper.update(article);
        return article;
    }
}
