package com.xh.auth.controller;

import cn.dev33.satoken.annotation.SaIgnore;
import cn.hutool.http.Header;
import com.xh.auth.api.response.ImageCaptchaDTO;
import com.xh.auth.api.response.LoginUserInfoVO;
import com.xh.auth.service.SysLoginService;
import com.xh.common.core.web.RestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 09:42
 */
@Tag(name = "用户管理")
@RestController
@RequestMapping("/api/system/user")
public class TokenController {

    @Resource
    private SysLoginService sysLoginService;


    @SaIgnore
    @Operation(description = "获取图形验证码")
    @GetMapping("/captcha")
    public RestResponse<ImageCaptchaDTO> getImageCaptcha(String captchaKey) {
        return RestResponse.success(sysLoginService.getImageCaptcha(captchaKey));
    }

    @SaIgnore
    @Operation(description = "登录")
    @PostMapping("/login")
    public RestResponse<LoginUserInfoVO> login(HttpServletRequest request, @RequestBody Map<String, Object> params) {
        params.put("USER_AGENT", request.getHeader(Header.USER_AGENT.toString()));
        return RestResponse.success(sysLoginService.login(params));
    }


}
