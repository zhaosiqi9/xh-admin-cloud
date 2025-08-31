package com.xh.system.application.service.sub;

import com.xh.common.base.web.RestResponse;
import com.xh.system.api.contract.RemoteSysMenuContract;
import com.xh.system.api.request.UserPermissionRequest;
import com.xh.system.api.response.UserPermissionResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
@Schema(description = "第三方服务")
public class ThirdPartyService {
    
    @Resource
    private RemoteSysMenuContract sysMenuContract;
    
    @Schema(description = "角色权限列表")
    public List<UserPermissionResponse> rolePermissionList(UserPermissionRequest request) {
        if (request == null || request.getRoleId() == null) {
            return List.of();
        }
       return Optional.ofNullable(sysMenuContract.rolePermissionList(request)).orElse(RestResponse.success()).getData();
    }
}
