package com.yrry.lushan.service.dto;

import java.util.List;

import lombok.Data;

@Data
public class PageDto<T> {
    private int pageNo;
    private int pageSize;
    private int total;
    private List<T> list;
}
