package com.xh.jwt.util;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.xh.jwt.dto.OnlineUserDTO;
import com.xh.jwt.dto.SysLoginUserInfoDTO;
import com.xh.jwt.dto.WxUserInfoDTO;

import static com.xh.jwt.constant.JwtConstant.SYS_USER_KEY;
import static com.xh.jwt.constant.JwtConstant.WX_USER_KEY;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/26 11:28
 */
public class JwtUtil {

    public static SysLoginUserInfoDTO getSysUserInfo() {
        SaSession session = StpUtil.getSession();
        if (session == null) {
            return null;
        }
        return session.getModel(SYS_USER_KEY, SysLoginUserInfoDTO.class);
    }

    /**
     * 获取当前微信登录用户信息
     */
    public static WxUserInfoDTO getWxUserInfo() {
        SaSession tokenSession = StpUtil.getTokenSession();
        if (tokenSession == null) {
            return null;
        }
        return tokenSession.getModel(WX_USER_KEY, WxUserInfoDTO.class );
    }

    /**
     * 获取当前登录用户详情
     */
    public static OnlineUserDTO getOnlineUserInfo() {
        SaSession tokenSession = StpUtil.getTokenSession();
        if (tokenSession == null) {
            return null;
        }
        return tokenSession.getModel(SYS_USER_KEY, OnlineUserDTO.class);
    }


}
