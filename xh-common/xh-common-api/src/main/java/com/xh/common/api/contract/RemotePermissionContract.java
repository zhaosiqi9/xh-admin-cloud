package com.xh.common.api.contract;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/24 20:08
 */
@FeignClient(contextId = "remotePermissionContract", value = "xh-system", path = "/api/system/permission")
public interface RemotePermissionContract {

    @PostMapping("/getPermissionList")
    List<String> getPermissionList(@RequestParam Long loginId, @RequestParam String loginType);

    @PostMapping("/getRoleList")
    List<String> getRoleList(@RequestParam Long loginId, @RequestParam String loginType);
}
