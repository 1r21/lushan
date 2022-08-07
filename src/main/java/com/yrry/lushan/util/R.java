package com.yrry.lushan.util;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class R<T> {
    private Integer code;
    private String message;
    private T data;

    private static <K> R<K> build(K data) {
        var result = new R<K>();
        if (data != null) {
            result.setData(data);
        } else {
            // remove `data` property ???
        }
        return result;
    }

    private static <K> R<K> build(K data, CodeEnum codeEnum) {
        var result = build(data);
        result.setCode(codeEnum.getCode());
        result.setMessage(codeEnum.getMessage());
        return result;
    }

    /**
     * success but no data
     */
    public static <K> R<K> ok() {
        return ok(null);
    }

    public static <K> R<K> ok(K data) {
        return build(data, CodeEnum.SUCCESS);
    }

    public static <K> R<K> fail() {
        return fail(null);
    }

    public static <K> R<K> fail(K data) {
        return build(data, CodeEnum.OTHER);
    }

}
