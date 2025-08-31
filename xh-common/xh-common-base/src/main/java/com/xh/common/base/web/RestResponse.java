package com.xh.common.base.web;

import com.xh.common.base.constant.HttpStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;

@Schema(title = "通用响应对象")
@Data
public class RestResponse<T> implements Serializable {

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
    public static <T> RestResponse<T> success() {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.httpCode = HttpStatus.OK.value();
        restResponse.status = "success";
        return restResponse;
    }

    /**
     * 响应成功信息，携带data
     */
    public static <T> RestResponse<T> success(T data) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.httpCode = HttpStatus.OK.value();
        restResponse.status = "success";
        restResponse.data = data;
        return restResponse;
    }

    /**
     * 错误响应，携带data
     */
    public static <T> RestResponse<T> errorData(T data) {
        RestResponse<T> restResponse = new RestResponse<>();
        restResponse.httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        restResponse.status = "error";
        restResponse.data = data;
        return restResponse;
    }

    /**
     * 错误响应
     */
    public static RestResponse<String> error() {
        RestResponse<String> restResponse = new RestResponse<>();
        restResponse.httpCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
        restResponse.status = "error";
        return restResponse;
    }

    /**
     * 错误响应，携带错误message
     */
    public static RestResponse<String> error(String message) {
        RestResponse<String> restResponse = error();
        restResponse.message = message;
        return restResponse;
    }
}
