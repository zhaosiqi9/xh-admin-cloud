package com.xh.system.application.service;

import com.alibaba.fastjson.JSON;
import com.xh.system.api.response.GetUserInfoResponse;
import com.xh.system.application.command.sysuser.GetUserInfoCommand;
import com.xh.system.application.command.sysuser.UpdateUserInfoCommand;
import com.xh.system.application.mapstract.SysUserEntity2ResponseMapper;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.service.SysUserDomainService;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

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

    public SysUserPO personalCenterSave(SysUserPO sysUserPO) {
        return null;
    }

    public SysUserPO getById(Serializable loginId) {
        return null;
    }

    public GetUserInfoResponse getUserInfo(GetUserInfoCommand command) {
        SysUserAggregate root =
                Optional.ofNullable(sysUserDomainService.getRootByLoginAccount(command.getUserName(), command.isEnabled(), command.getType())).orElseThrow(() -> new RuntimeException("用户不存在"));
        log.info("root:{}", JSON.toJSONString(root));
        return SysUserEntity2ResponseMapper.INSTANCE.toGetUserInfoResponse(root);
    }

    public boolean clearFailuresNum(UpdateUserInfoCommand command) {
        SysUserAggregate root = Optional.ofNullable(sysUserDomainService.getRoot(command.getId(), command.getType())).orElseThrow(() -> new RuntimeException("用户不存在"));
        sysUserDomainService.clearFailuresNum(root, command.getId(), command.getType());
        return true;
    }

    public boolean loginFailUpdateInfo(UpdateUserInfoCommand command) {
        SysUserAggregate root = Optional.ofNullable(sysUserDomainService.getRoot(command.getId(), command.getType())).orElseThrow(() -> new RuntimeException("用户不存在"));
        sysUserDomainService.loginFailUpdateInfo(root,
                command.getId(),
                command.getFailuresNum(),
                command.getStatus(),
                command.getLockMsg(),
                command.getType());
        return true;
    }

}
