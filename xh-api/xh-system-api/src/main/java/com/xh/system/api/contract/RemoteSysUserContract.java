package com.xh.system.api.contract;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 12:45
 */
@FeignClient(contextId = "remoteSysUserService", value = "xh-system", path = "/api/system/user")
public interface RemoteSysUserContract {

    @PostMapping("get-user-info")
    void getUserInfo(@RequestBody Map<String, Object> params);
}
