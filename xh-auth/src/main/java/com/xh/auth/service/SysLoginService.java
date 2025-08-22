package com.xh.auth.service;

import com.xh.auth.api.response.ImageCaptchaDTO;
import com.xh.auth.api.response.LoginUserInfoVO;
import com.xh.system.api.contract.RemoteSysUserContract;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 09:53
 */
@Service
public class SysLoginService {

    @Resource
    private RemoteSysUserContract remoteUserContract;

    public ImageCaptchaDTO getImageCaptcha(String captchaKey) {
        return null;
    }

    public LoginUserInfoVO login(Map<String, Object> params) {
        remoteUserContract.getUserInfo(params);
        return null;
    }
}
