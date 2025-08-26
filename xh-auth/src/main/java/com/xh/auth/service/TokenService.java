package com.xh.auth.service;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.secure.BCrypt;
import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.stp.parameter.SaLoginParameter;
import cn.hutool.captcha.AbstractCaptcha;
import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import com.xh.auth.api.request.LoginRequest;
import com.xh.auth.constant.LoginUtil;
import com.xh.auth.mapstruct.Entity2DTOMapper;
import com.xh.auth.service.dto.*;
import com.xh.auth.util.RequestUtil;
import com.xh.jwt.constant.JwtConstant;
import com.xh.common.core.constants.SystemRedisConstant;
import com.xh.common.core.web.MyException;
import com.xh.system.api.constant.sysuser.SysUserConstant;
import com.xh.system.api.contract.RemoteSysMenuContract;
import com.xh.system.api.contract.RemoteSysUserContract;
import com.xh.system.api.request.GetUserInfoRequest;
import com.xh.system.api.request.UpdateUserInfoRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.api.response.GetUserInfoResponseJob;
import com.xh.system.api.response.GetUserInfoResponseUser;
import com.xh.system.api.response.UserPermissionResponse;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private Entity2DTOMapper entity2DTOMapper;
    @Resource
    private RemoteSysMenuContract remoteMenuContract;

    /**
     * 生成图形验证码
     */
    public ImageCaptchaDTO getImageCaptcha(String captchaKey) {
        //定义图形验证码的长、宽、验证码字符数、干扰元素个数
        AbstractCaptcha captcha = CaptchaUtil.createLineCaptcha(100, 30, 4, 10);
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        ImageCaptchaDTO imageCaptcha = new ImageCaptchaDTO();
        imageCaptcha.setCaptchaKey(captchaKey);
        imageCaptcha.setImageBase64(captcha.getImageBase64Data());
        valueOperations.set(SystemRedisConstant.CAPTCHA_KEY_PREFIX.getValue() + captchaKey, captcha, 2, TimeUnit.MINUTES);
        return imageCaptcha;
    }

    public LoginUserInfoVO login(LoginRequest request) {

        HttpServletRequest currentRequest = RequestUtil.getCurrentRequest();

        val username = request.getUsername();
        val captchaKey = request.getCaptchaKey();
        val captchaCode = request.getCaptchaCode();
        val password = request.getPassword();
        GetUserInfoResponse userInfoResponse =
                remoteUserContract.getUserInfo(new GetUserInfoRequest().setUserName(username).setEnabled(true).setType(SysUserConstant.GetUpdateUserInfoType.ORG_ROLE));
        GetUserInfoResponseUser sysUser = userInfoResponse.getUser();

        SaSession session = null;
        try {
            session = StpUtil.getSession();
        } catch (NotLoginException e) {
            log.info("用户未登录需要重新登录~");
        }
        //尝试登录
        if (session == null && StrUtil.isNotBlank(username)) {

            if (request.isDemo()) {
                if (StrUtil.isBlank(captchaKey)) throw new MyException("非法登录");
                if (StrUtil.isBlank(captchaCode)) throw new MyException("请输入图形验证码");

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


            if (sysUser == null) throw new MyException("账号不存在");
            if (sysUser.getStatus() == 2)
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
                    remoteUserContract.loginFailUpdateInfo(new UpdateUserInfoRequest().initFromResponse(sysUser, SysUserConstant.GetUpdateUserInfoType.DEFAULT));
                }
            } else {
                //失败次数置零
                remoteUserContract.clearFailuresNum(new UpdateUserInfoRequest().initFromResponse(sysUser, SysUserConstant.GetUpdateUserInfoType.DEFAULT));
            }

            //获取用户岗位角色
            List<GetUserInfoResponseJob> roles = userInfoResponse.getJobList();
            if (roles.isEmpty()) {
                throw new MyException("该用户未分配角色，无法登录!");
            }

            SaLoginParameter loginParameter = new SaLoginParameter();
            loginParameter.setDeviceType("WEB");
            //如果账号不允许重复登录，则将已登录的强制下线
            loginParameter.setIsConcurrent(sysUser.getAllowRepeat());
            // 登录
            StpUtil.login(sysUser.getId(), loginParameter);

            session = StpUtil.getSession();

            // 刷新用户信息和权限缓存
            SysUserDTO sysUserDTO = new SysUserDTO();
            BeanUtils.copyProperties(sysUser, sysUserDTO);
            SysLoginUserInfoDTO loginUserInfoDTO = new SysLoginUserInfoDTO();
            loginUserInfoDTO.setUser(sysUserDTO);
            loginUserInfoDTO.setRoles(entity2DTOMapper.toSysOrgRoleDTOList(roles));
            session.set(JwtConstant.SYS_USER_KEY, loginUserInfoDTO);

            UserAgent ua = UserAgentUtil.parse(request.getUserAgent());
            OnlineUserDTO onlineUserDTO = new OnlineUserDTO();
            onlineUserDTO.setToken(StpUtil.getTokenValue());
            onlineUserDTO.setUserId(sysUser.getId());
            onlineUserDTO.setUserCode(sysUser.getCode());
            onlineUserDTO.setUserName(sysUser.getName());
            if (ua != null) {
                onlineUserDTO.setLoginBrowser(ua.getBrowser().getName());
                onlineUserDTO.setBrowserVersion(ua.getVersion());
                onlineUserDTO.setLoginBrowser(ua.getBrowser().getName());
                onlineUserDTO.setLoginOs(ua.getOs().getName());
                onlineUserDTO.setIsMobile(ua.isMobile());
            }
            String loginIp = currentRequest.getHeader("X-Real-IP");
            if (StrUtil.isBlank(loginIp)) {
                loginIp = currentRequest.getRemoteAddr();
            }
            onlineUserDTO.setLoginIp(loginIp);
            onlineUserDTO.setLoginAddress(RequestUtil.getIpRegion2(onlineUserDTO.getLoginIp()));
            onlineUserDTO.setLocale(request.getLocale());
            onlineUserDTO.setLocaleLabel(request.getLocaleLabel());

            SysOrgRoleDTO orgRole = entity2DTOMapper.toSysOrgRoleDTO(roles.get(0)); //默认当前使用角色为第一个角色
            onlineUserDTO.setOrgId(orgRole.getSysOrgId());
            onlineUserDTO.setRoleId(orgRole.getSysRoleId());
            onlineUserDTO.setOrgName(orgRole.getOrgName());
            onlineUserDTO.setRoleName(orgRole.getRoleName());
            onlineUserDTO.setLoginTime(LocalDateTime.now());
            StpUtil.getTokenSession().set(JwtConstant.SYS_USER_KEY, onlineUserDTO);
            return getCurrentLoginUserVO(true);
        }
        return getCurrentLoginUserVO(false);
    }

    /**
     * 获取当前token的用户角色信息
     *
     * @param refresh 是否刷新缓存
     */
    private LoginUserInfoVO getCurrentLoginUserVO(Boolean refresh) {
        try {
            SaSession session = StpUtil.getSession();
            SaSession tokenSession = StpUtil.getTokenSession();
            LoginUserInfoVO loginUserInfo = null;
            if (session != null && tokenSession != null) {
                SysLoginUserInfoDTO loginUserInfoDTO = session.getModel(JwtConstant.SYS_USER_KEY, SysLoginUserInfoDTO.class);
                loginUserInfo = new LoginUserInfoVO();
                loginUserInfo.setTokenName(StpUtil.getTokenName());
                loginUserInfo.setTokenValue(StpUtil.getTokenValue());
                loginUserInfo.setUser(loginUserInfoDTO.getUser());
                OnlineUserDTO onlineUser = tokenSession.getModel(JwtConstant.SYS_USER_KEY, OnlineUserDTO.class);
                List<SysOrgRoleDTO> roles = loginUserInfoDTO.getRoles();
                for (SysOrgRoleDTO role : roles) {
                    role.setActive(Objects.equals(onlineUser.getRoleId(), role.getSysRoleId()) && Objects.equals(onlineUser.getOrgId(), role.getSysOrgId()));
                }
                loginUserInfo.setRoles(roles);
                loginUserInfo.setMenus(getRolePermissions(onlineUser.getRoleId(), refresh));
            }
            return loginUserInfo;
        } catch (NotLoginException e) {
            return null;
        }
    }

    private List<SysMenuDTO> getRolePermissions(Long roleId, Boolean refresh) {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        if (refresh == Boolean.FALSE) {
            RolePermissionsDTO rolePermissions = (RolePermissionsDTO) operations.get(SystemRedisConstant.ROLE_PERMISSIONS_PREFIX.getValue() + roleId);
            if (rolePermissions != null) {
                return rolePermissions.getPermissions();
            }
        }
        List<UserPermissionResponse> permissions = remoteMenuContract.rolePermissionList(roleId);
        List<SysMenuDTO> list = Entity2DTOMapper.INSTANCE.permissionList2SysMenuDTOList(permissions);
        return list;
    }

    public LoginUserInfoVO refreshToken(HttpServletRequest request) {

        String tokenValue = StpUtil.getTokenValue();
        SaTokenInfo tokenInfo = StpUtil.getTokenInfo();
        log.info(tokenValue);
        log.info(tokenInfo.toString());
        log.info(StpUtil.getLoginId().toString());
        return null;
    }

    public boolean logout() {
        StpUtil.logout();
        return true;
    }

    public boolean kickOut() {
        Object loginId = StpUtil.getLoginId();
        if (loginId == null) {
            throw new RuntimeException("当前用户未登录");
        }
        StpUtil.kickout(loginId);
        return true;
    }
}
