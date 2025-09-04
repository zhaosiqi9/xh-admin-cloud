package com.xh.system.interfaces;

import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.common.base.web.RestResponse;
import com.xh.system.api.request.RoleQueryRequest;
import com.xh.system.api.response.RoleQueryResponse;
import com.xh.system.application.service.SysRoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/api/system/role")
@Tag(name = "系统角色管理")
public class SysRoleController {
    @Resource
    private SysRoleService sysRoleService;
    @PostMapping("/query")
    public RestResponse<PageResult<RoleQueryResponse>> query(@RequestBody PageQuery<RoleQueryRequest> request){
        return RestResponse.success(Optional.ofNullable(request).map(t -> sysRoleService.query(t)).orElse(null));
    }
}
