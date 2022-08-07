package com.yrry.lushan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Entry {
    @GetMapping("/api")
    public String index() {
        return "This is entry of endpoint";
    }
}
