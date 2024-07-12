package com.sun.xxm.mapper;

import com.mybatisflex.core.BaseMapper;
import com.sun.xxm.model.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper  extends BaseMapper<Article> {
}
