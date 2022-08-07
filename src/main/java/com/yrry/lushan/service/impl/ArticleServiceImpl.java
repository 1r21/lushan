package com.yrry.lushan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrry.lushan.mapper.ArticleMapper;
import com.yrry.lushan.service.ArticleService;
import com.yrry.lushan.service.dto.ArticleDetailDto;
import com.yrry.lushan.service.dto.ArticleThumbDto;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ArticleThumbDto> getArticles(int pageNo, int pageSize) {
        var articles = articleMapper.getAll(pageSize, (pageNo - 1) * pageSize);
        var results = new ArrayList<ArticleThumbDto>();
        articles.forEach(article -> {
            var aDto = new ArticleThumbDto(article);
            results.add(aDto);
        });
        return results;
    }

    @Override
    public ArticleDetailDto findById(int id) {
        var article = articleMapper.findById(id);
        if (article != null) {
            var result = new ArticleDetailDto(article);
            return result;
        }
        return null;
    }

    @Override
    public int getArticleTotal() {
        return articleMapper.getTotal();
    }

}
