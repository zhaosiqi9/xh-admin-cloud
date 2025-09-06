package com.xh.system.api.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "切换用户字段值")
public class UserSwitchMenuPropRequest {
    
    @Schema(description = "用户id")
    private Long id;

    @Schema(description = "字段名")
    private String prop;
    
    @Schema(description = "字段值")
    private boolean value;
}
