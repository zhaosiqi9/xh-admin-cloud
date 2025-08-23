package com.xh.system.api.contract;

import com.xh.system.api.response.UserPermissionResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 01:15
 */
@FeignClient(contextId = "remoteSysMenuContract", value = "xh-system", path = "/api/system/menu")
public interface RemoteSysMenuContract {

    @PostMapping("role-permission-list")
    List<UserPermissionResponse> rolePermissionList(@RequestBody Long roleId);

}
