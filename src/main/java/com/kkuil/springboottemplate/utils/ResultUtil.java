package com.kkuil.springboottemplate.utils;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * @Author 小K
 * @Date 2023/08/03 23:00
 * @Description 返回结果工具类
 */
@Data
public class ResultUtil<DataType> {
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private DataType data;

    public ResultUtil(Integer code, String message, DataType data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * Success
     *
     * @return
     */
    public static ResultUtil<String> success() {
        return new ResultUtil<>(HttpStatus.OK.value(), "success", null);
    }

    public static ResultUtil<String> success(String message) {
        return new ResultUtil<>(HttpStatus.OK.value(), message, null);
    }

    public static <DT> ResultUtil<DT> success(DT data) {
        return new ResultUtil<>(HttpStatus.OK.value(), "success", data);
    }

    public static <DT> ResultUtil<DT> success(String message, DT data) {
        return new ResultUtil<>(HttpStatus.OK.value(), message, data);
    }


    /**
     * Error
     *
     * @return
     */
    public static ResultUtil<String> error() {
        return new ResultUtil<>(HttpStatus.BAD_REQUEST.value(), "error", null);
    }

    public static ResultUtil<String> error(String message) {
        return new ResultUtil<>(HttpStatus.OK.value(), message, null);
    }

    public static <DT> ResultUtil<DT> error(DT data) {
        return new ResultUtil<>(HttpStatus.BAD_REQUEST.value(), "error", data);
    }

    public static <DT> ResultUtil<DT> error(Integer code, DT data) {
        return new ResultUtil<>(code, "error", data);
    }

    public static <DT> ResultUtil<DT> error(String message, DT data) {
        return new ResultUtil<>(HttpStatus.BAD_REQUEST.value(), message, data);
    }

    public static <DT> ResultUtil<DT> error(Integer code, String message, DT data) {
        return new ResultUtil<>(code, message, data);
    }
}
