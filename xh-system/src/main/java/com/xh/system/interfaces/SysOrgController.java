package com.xh.system.interfaces;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.common.base.web.RestResponse;
import com.xh.common.core.annotation.Log;
import com.xh.system.api.request.OrgQueryRequest;
import com.xh.system.api.response.OrgQueryResponse;
import com.xh.system.application.service.SysOrgService;
import com.xh.system.domain.entity.SysOrg;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
    
     @Operation(description = "机构树查询")
    @GetMapping("/tree")
    public RestResponse<PageResult<SysOrg>> query(String name) {
        PageResult<SysOrg> data = sysOrgService.queryOrgTree(name);
        return RestResponse.success(data);
    }
    

    @SaCheckPermission(value = {"system:org:add", "system:org:edit"}, mode = SaMode.OR)
    @Operation(description = "机构保存")
    @PostMapping("/save")
    public RestResponse<SysOrg> save(@RequestBody SysOrg sysOrg) {
        return RestResponse.success(sysOrgService.save(sysOrg));
    }

    @SaCheckPermission(value = {"system:org:edit", "system:org:detail"}, mode = SaMode.OR)
    @Operation(description = "获取机构详情")
    @GetMapping("/get/{id}")
    public RestResponse<SysOrg> getById(@PathVariable Long id) {
        return RestResponse.success(sysOrgService.getById(id));
    }

    @SaCheckPermission("system:org:del")
    @Operation(description = "机构批量删除")
    @DeleteMapping("/del")
    public RestResponse<?> del(@RequestParam List<Long> ids) {
        sysOrgService.del(ids);
        return RestResponse.success();
    }
}
