package com.sun.xxm.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sun.xxm.model.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper  extends BaseMapper<Article> {
}
