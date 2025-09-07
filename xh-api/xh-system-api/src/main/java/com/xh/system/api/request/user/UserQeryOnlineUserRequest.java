package com.xh.system.api.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户查询在线用户参数")
public class UserQeryOnlineUserRequest {
    
    @Schema(title = "用户code")
    private String userCode;
    
    @Schema(title = "用户")
    private String userName;
    
    @Schema(title = "ip地址")
    private String ip;
}
