package com.yrry.lushan.model;

import lombok.Data;

@Data
public class Article {
    private int id;
    private String title;
    private String audio_url;
    private String image_url;
    private String summary;
    private String transcript;
    private String source; 
    private String date;
}