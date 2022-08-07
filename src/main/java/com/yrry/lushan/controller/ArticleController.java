package com.yrry.lushan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yrry.lushan.model.Article;
import com.yrry.lushan.service.ArticleService;
import com.yrry.lushan.service.dto.ArticleThumbDto;
import com.yrry.lushan.service.dto.PageDto;
import com.yrry.lushan.util.R;

@CrossOrigin
@RequestMapping("/api")
@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/news")
    public R<?> getArticles(
            @RequestParam(value = "page", required = false, defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", required = false, defaultValue = "20") int pageSize) {
        var total = articleService.getArticleTotal();
        var articles = articleService.getArticles(pageNo, pageSize);
        var pageDto = new PageDto<ArticleThumbDto>();
        pageDto.setPageNo(pageNo);
        pageDto.setPageSize(pageSize);
        pageDto.setList(articles);
        pageDto.setTotal(total);
        return R.ok(pageDto);
    }

    @GetMapping("/news/detail")
    public R<?> getArticleById(@RequestBody Article article) {
        var id = article.getId();
        var result = articleService.findById(id);
        if (result != null) {
            return R.ok(result);
        }
        return R.fail();
    }
}
