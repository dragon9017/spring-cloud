package com.api.commons;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 公用结果返回集的类
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class CommonResult<T> {
    /**
     * 结果返回编码
     */
    private Integer code;

    /**
     * 结果返回信息
     */
    private String message;

    /**
     * 使用当前工具类的类
     */

    private T   data;

    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
