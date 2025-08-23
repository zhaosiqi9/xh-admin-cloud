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
        SysUserAggregate root = sysUserDomainService.getRootByLoginAccount(command.getUserName(), command.isEnabled(), command.getType());
        log.info("root:{}", JSON.toJSONString(root));
        return SysUserEntity2ResponseMapper.INSTANCE.toGetUserInfoResponse(root.getSysUser());
    }

    public boolean updateUserInfo(UpdateUserInfoCommand command) {
//        SysUser entity = SysUserRequest2CommandMapper.INSTANCE.toEntity(request);
//        return sysUserDomainService.updateUserInfo(entity);
        return true;
    }
}
