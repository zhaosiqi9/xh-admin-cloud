package com.xh.auth.service;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.captcha.AbstractCaptcha;
import com.xh.auth.api.request.LoginRequest;
import com.xh.auth.api.response.ImageCaptchaDTO;
import com.xh.auth.api.response.LoginUserInfoVO;
import com.xh.common.core.utils.CommonUtil;
import com.xh.common.core.web.MyException;
import com.xh.system.api.constant.sysuser.SysUserConstant;
import com.xh.system.api.contract.RemoteSysUserContract;
import com.xh.system.api.request.GetUserInfoRequest;
import com.xh.system.api.request.UpdateUserInfoRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 09:53
 */
@Service
@Slf4j
public class TokenService {

    @Resource
    private RemoteSysUserContract remoteUserContract;

    @Resource
    private RedisTemplate redisTemplate;

    public ImageCaptchaDTO getImageCaptcha(String captchaKey) {
        return null;
    }

    public LoginUserInfoVO login(LoginRequest request) {
        val username = request.getUsername();
        val captchaKey = request.getCaptchaKey();
        val captchaCode = request.getCaptchaCode();
        val password = request.getPassword();
        GetUserInfoResponse userInfo = remoteUserContract.getUserInfo(new GetUserInfoRequest().setUserName(username));

        SaSession session = null;
        try {
            session = StpUtil.getSession();
        } catch (NotLoginException e) {
            log.info("用户未登录需要重新登录~");
        }
        //尝试登录
        if (session == null && CommonUtil.isNotEmpty(username)) {

            if (request.isDemo()) {
                if (CommonUtil.isEmpty(captchaKey)) throw new MyException("非法登录");
                if (CommonUtil.isEmpty(captchaCode)) throw new MyException("请输入图形验证码");

                //验证图形验证码
                ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                String key = "captcha:" + captchaKey;
                AbstractCaptcha captcha = (AbstractCaptcha) valueOperations.get(key);
                //删除验证码
                redisTemplate.delete(key);
                if (captcha == null) throw new MyException("验证码已失效");
                boolean verify = captcha.verify(captchaCode);
                if (!verify) throw new MyException("验证码错误");
            }

            GetUserInfoResponse sysUser = remoteUserContract.getUserInfo(new GetUserInfoRequest().setUserName(username).setEnabled(true));

            if (sysUser == null) throw new MyException("账号不存在");
            if (CommonUtil.getString(sysUser.getStatus()).equals("2"))
                throw new MyException(sysUser.getLockMsg());
            boolean matches = BCrypt.checkpw(password, sysUser.getPassword());
            if (!matches) {
                if (Boolean.TRUE.equals(sysUser.getIsDemo())) {
                    throw new MyException("密码错误！");
                }
                try {
                    //最大尝试次数
                    int maxTryNum = 3;
                    Integer failuresNum = sysUser.getFailuresNum();
                    if (failuresNum == null) failuresNum = 0;
                    failuresNum++;
                    //记录登录失败次数
                    sysUser.setFailuresNum(failuresNum);
                    //失败次数大于最大尝试次数账号锁定，保存
                    if (failuresNum >= maxTryNum) {
                        sysUser.setStatus(2);
                        sysUser.setLockMsg("用户登录失败次数超过%s次，账号已锁定，请联系管理员处理。".formatted(maxTryNum));
                        throw new MyException(sysUser.getLockMsg());
                    }
                    throw new MyException("密码错误！您还可以尝试%s次。".formatted(maxTryNum - failuresNum));
                } finally {
                    remoteUserContract.updateUserInfo(new UpdateUserInfoRequest().initFromResponse(sysUser.getUser(), SysUserConstant.GetUpdateUserInfoType.DEFAULT));
                }
            } else {
                //失败次数置零
                sysUser.setFailuresNum(0);
                sysUser.setLockMsg(null);
                remoteUserContract.updateUserInfo(new UpdateUserInfoRequest().initFromResponse(sysUser.getUser(), SysUserConstant.GetUpdateUserInfoType.DEFAULT));
            }

            return null;
        }
        return null;
    }
}
