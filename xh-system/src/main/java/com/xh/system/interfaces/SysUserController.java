package com.xh.system.interfaces;

import com.xh.common.core.web.RestResponse;
import com.xh.system.api.contract.RemoteSysUserContract;
import com.xh.system.api.request.GetUserInfoRequest;
import com.xh.system.api.request.UpdateUserInfoRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.LoginUserInfoVO;
import com.xh.system.application.mapstract.SysUserRequest2CommandMapper;
import com.xh.system.application.service.SysLoginService;
import com.xh.system.application.service.SysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Optional;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/system/user")
public class SysUserController implements RemoteSysUserContract {

    @Resource
    private SysLoginService sysLoginService;
    @Resource
    private SysUserService sysUserService;
    @Autowired
    private SysUserRequest2CommandMapper sysUserRequest2CommandMapper;

    @Operation(description = "登录")
    @PostMapping("/login")
    public RestResponse<LoginUserInfoVO> login(HttpServletRequest request, @RequestBody Map<String, Object> params) {
        return null;
    }


    @Override
    public GetUserInfoResponse getUserInfo(GetUserInfoRequest request) {
        return Optional.ofNullable(request)
                .map(t -> sysUserRequest2CommandMapper.getUserInfoRequest2Command(t))
                .map(t -> sysUserService.getUserInfo(t))
                .orElse(null);
    }

    @Override
    public boolean updateUserInfo(UpdateUserInfoRequest request) {
        return Optional.ofNullable(request)
                .map(t -> sysUserRequest2CommandMapper.updateUserInfoRequest2Command(t))
                .map(t -> sysUserService.updateUserInfo(t))
                .orElse(false);
    }
}
