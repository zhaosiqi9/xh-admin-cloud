package com.xh.system.api.request.role;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "角色保存请求参数")
public class SysRoleSaveRequestMenu {

    @Schema(title = "id")
    private Long id;
    
    @Schema(title = "角色id")
    private Integer sysRoleId;
    
    @Schema(title = "菜单id")
    private Integer sysMenuId;
}
