package com.xh.auth.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.http.Header;
import com.xh.auth.api.request.LoginRequest;
import com.xh.auth.service.TokenService;
import com.xh.auth.service.dto.ImageCaptchaDTO;
import com.xh.auth.service.dto.LoginUserInfoVO;
import com.xh.common.core.annotation.Log;
import com.xh.common.core.web.RestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/system/user")
public class LoginController {

    @Resource
    private TokenService tokenService;

    @Log
    @SaIgnore
    @Operation(description = "获取图形验证码")
    @GetMapping("/captcha")
    public RestResponse<ImageCaptchaDTO> getImageCaptcha(@Parameter(description = "验证码key") String captchaKey) {
        return RestResponse.success(tokenService.getImageCaptcha(captchaKey));
    }

    @Log
    @SaIgnore
    @Operation(description = "登录")
    @PostMapping("/login")
    public RestResponse<LoginUserInfoVO> login(HttpServletRequest request, @RequestBody LoginRequest loginRequest) {
        loginRequest.setUserAgent(request.getHeader(Header.USER_AGENT.toString()));
        return RestResponse.success(tokenService.login(loginRequest));
    }

    @Log
    @SaIgnore
    @Operation(description = "刷新token")
    @PostMapping("/refreshToken")
    public RestResponse<LoginUserInfoVO> refreshToken(HttpServletRequest request) {
        return RestResponse.success(tokenService.refreshToken(request));
    }

    @Log
    @Operation(description = "注销")
    @PostMapping("/logout")
    public RestResponse<?> logout() {
        return RestResponse.success(tokenService.logout());
    }

    @Log
    @Operation(description = "踢人下线")
    @PostMapping("/kickOut")
    public RestResponse<?> kickOut() {
        return RestResponse.success(tokenService.kickOut());
    }

}
