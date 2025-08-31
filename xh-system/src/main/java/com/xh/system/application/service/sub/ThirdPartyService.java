package com.xh.system.application.service.sub;

import com.xh.system.api.contract.RemoteSysMenuContract;
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
    public List<UserPermissionResponse> rolePermissionList(Long roleId) {
        if (roleId == null) {
            return List.of();
        }
       return Optional.ofNullable(sysMenuContract.rolePermissionList(roleId)).orElse(List.of());
    }
}
