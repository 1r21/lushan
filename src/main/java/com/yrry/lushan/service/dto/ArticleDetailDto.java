package com.yrry.lushan.service.dto;

import com.yrry.lushan.model.Article;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ArticleDetailDto extends ArticleThumbDto {
    private String src;
    private String transcript;

    public ArticleDetailDto(Article article) {
        super(article);
        this.src = article.getSource();
        this.transcript = article.getTranscript();
    }
}
