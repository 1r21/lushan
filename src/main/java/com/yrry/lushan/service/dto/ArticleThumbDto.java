package com.yrry.lushan.service.dto;

import com.yrry.lushan.model.Article;

import lombok.Data;

@Data
public class ArticleThumbDto {
    private int id;
    private String title;
    private String date;
    private String cover;

    public ArticleThumbDto(Article article) {
        this.date = article.getDate();
        this.id = article.getId();
        this.title = article.getTitle();
        this.cover = article.getImage_url();
    }
}
