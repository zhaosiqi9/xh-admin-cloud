package com.xh.system.api.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "系统用户查询参数")
public class SystemUserQueryRequestParam {
    @Schema(description = "账号")
    private String code;

    @Schema(description = "名称")
    private String name;

}
