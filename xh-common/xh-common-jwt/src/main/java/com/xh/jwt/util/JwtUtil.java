package com.xh.jwt.util;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;

import static com.xh.jwt.constant.JwtConstant.SYS_USER_KEY;
import static com.xh.jwt.constant.JwtConstant.WX_USER_KEY;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/26 11:28
 */
public class JwtUtil {

    public static <T> T getSysUserInfo(Class<T> T) {
        SaSession session = StpUtil.getSession();
        if (session == null) {
            return null;
        }
        return session.getModel(SYS_USER_KEY, T);
    }

    /**
     * 获取当前登录用户详情
     */
    public static <T> T getOnlineUserInfo(Class<T> T) {
        SaSession tokenSession = StpUtil.getTokenSession();
        if (tokenSession == null) {
            return null;
        }
        return tokenSession.getModel(SYS_USER_KEY, T);
    }

    /**
     * 获取当前微信登录用户信息
     */
    public static <T> T getWxUserInfo(Class<T> T) {
        SaSession tokenSession = StpUtil.getTokenSession();
        if (tokenSession == null) {
            return null;
        }
        return tokenSession.getModel(WX_USER_KEY, T);
    }


}
