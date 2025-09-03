package com.xh.system.interfaces;

import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.common.base.web.RestResponse;
import com.xh.common.core.annotation.Log;
import com.xh.system.api.request.OrgQueryRequest;
import com.xh.system.api.response.OrgQueryResponse;
import com.xh.system.application.service.SysOrgService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/system/org")
@Tag(name = "组织管理")
public class SysOrgController {
    
    @Resource
    private SysOrgService sysOrgService;
  
    @Log
    @Operation(description = "查询组织")
    @PostMapping("/query")
    public RestResponse<PageResult<OrgQueryResponse>> query(@RequestBody PageQuery<OrgQueryRequest> request) {
        return RestResponse.success(Optional.ofNullable(request).map(t -> sysOrgService.query(t)).orElse(null));
    }
}
