package com.yrry.lushan.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {

    SUCCESS(0, "success"),
    PERMISSION(3001, "no auth"),
    TOKEN_ERROR(3002, "token is invalid"),
    OTHER(4000, "error");

    private final Integer code;
    private final String message;
}
