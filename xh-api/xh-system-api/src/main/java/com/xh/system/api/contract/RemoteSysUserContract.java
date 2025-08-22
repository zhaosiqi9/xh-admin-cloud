package com.xh.system.api.contract;

import com.xh.system.api.request.GetUserInfoRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 12:45
 */
@FeignClient(contextId = "remoteSysUserService", value = "xh-system", path = "/api/system/user")
public interface RemoteSysUserContract {

    @PostMapping("get-user-info")
    GetUserInfoResponse getUserInfo(@RequestBody GetUserInfoRequest request);
    
    @PostMapping("update-user-info")
    boolean updateUserInfo(@RequestBody GetUserInfoResponse request);
}
