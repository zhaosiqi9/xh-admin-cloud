package com.xh.system.application.service;

import com.alibaba.fastjson.JSON;
import com.xh.common.core.entity.SysUserRecord;
import com.xh.system.api.request.GetUserInfoRequest;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.application.mapstract.SysUserRequest2EntityMapper;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.constant.SysUserConstant;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.service.SysUserDomainService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 12:48
 */
@Service
@Slf4j
public class SysUserService {
    @Resource
    private SysUserDomainService sysUserDomainService;

    public SysUserRecord personalCenterSave(SysUserRecord sysUserRecord) {
        return null;
    }

    public SysUserRecord getById(Serializable loginId) {
        return null;
    }

    public GetUserInfoResponse getUserInfo(GetUserInfoRequest request) {
        SysUserAggregate root = sysUserDomainService.getRootByLoginAccount(request.getUserName(), request.isEnabled() , SysUserConstant.DEFAULT);
        log.info("root:{}", JSON.toJSONString(root));
        return GetUserInfoResponse.builder()
                .id(root.getRootId())
                .code(root.getSysUser().getCode())
                .name(root.getSysUser().getName())
                .password(root.getSysUser().getPassword())
                .avatar(root.getSysUser().getAvatar())
                .telephone(root.getSysUser().getTelephone())
                .status(root.getSysUser().getStatus())
                .failuresNum(root.getSysUser().getFailuresNum())
                .lockMsg(root.getSysUser().getLockMsg())
                .allowRepeat(root.getSysUser().getAllowRepeat())
                .autoRenewal(root.getSysUser().getAutoRenewal())
                .isDemo(root.getSysUser().getIsDemo())
                .roleSorter(root.getSysUser().getRoleSorter())
                .roleSorter(root.getSysUser().getRoleSorter())
                .enabled(root.getSysUser().getEnabled())
                .createTime(root.getSysUser().getCreateTime())
                .updateTime(root.getSysUser().getUpdateTime())
                .createBy(root.getSysUser().getCreateBy())
                .updateBy(root.getSysUser().getUpdateBy())
                .deleted(root.getSysUser().getDeleted())
                .build();
    }

    public boolean updateUserInfo(GetUserInfoResponse request) {
        SysUser entity = SysUserRequest2EntityMapper.INSTANCE.toEntity(request);
        return sysUserDomainService.updateUserInfo(entity);
    }
}
