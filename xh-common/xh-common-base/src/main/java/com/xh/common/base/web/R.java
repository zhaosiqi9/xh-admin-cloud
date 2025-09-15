package com.xh.common.base.web;

import com.xh.common.base.constant.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(title = "通用响应对象")
@Data
public class R<T> implements Serializable {

    @Schema(title = "http状态码", description = "正确响应码为200")
    private Integer httpCode;

    @Schema(title = "响应消息状态", allowableValues = {"success", "error", "warning", "info"})
    private String status;

    @Schema(title = "响应的消息内容")
    private String message;

    private T data;
    
     /**
     * 响应成功信息
     */
    public static <T> R<T> success() {
        R<T> r = new R<>();
        r.httpCode = HttpStatus.OK.value();
        r.status = "success";
        return r;
    }

    /**
     * 响应成功信息，携带data
     */
    public static <T> R<T> success(T data) {
        R<T> r = new R<>();
        r.httpCode = HttpStatus.OK.value();
        r.status = "success";
        r.data = data;
        return r;
    }

    /**
     * 错误响应，携带data
     */
    public static <T> R<T> errorData(T data) {
        R<T> r = new R<>();
        r.httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        r.status = "error";
        r.data = data;
        return r;
    }

    /**
     * 错误响应
     */
    public static R<String> error() {
        R<String> r = new R<>();
        r.httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        r.status = "error";
        return r;
    }

    /**
     * 错误响应，携带错误message
     */
    public static R<String> error(String message) {
        R<String> r = error();
        r.message = message;
        return r;
    }
}
