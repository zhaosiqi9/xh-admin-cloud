package com.xh.system.application.command.sysorg;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xh.system.api.request.OrgQueryRequest;
import com.xh.system.infrastructure.mysql.po.SysOrgPO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Schema(title = "组织查询参数")
@Accessors(chain = true)
public class OrgQueryCommand {
    
    
}
