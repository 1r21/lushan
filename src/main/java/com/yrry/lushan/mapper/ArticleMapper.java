package com.yrry.lushan.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yrry.lushan.model.Article;

@Mapper
public interface ArticleMapper {
    @Select("SELECT id,title,date,image_url FROM news ORDER BY id DESC LIMIT #{limit} OFFSET #{offset}")
    List<Article> getAll(@Param("limit") int limit, @Param("offset") int offset);

    @Select("SELECT * FROM news WHERE id = #{id}")
    Article findById(@Param("id") int id);

    @Select("SELECT COUNT(*) FROM news")
    int getTotal();
}
;