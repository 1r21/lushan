package com.yrry.lushan.service;

import java.util.List;

import com.yrry.lushan.service.dto.ArticleDetailDto;
import com.yrry.lushan.service.dto.ArticleThumbDto;

public interface ArticleService {
    List<ArticleThumbDto> getArticles(int pageNo, int pageSize);

    ArticleDetailDto findById(int id);

    int getArticleTotal();
}
