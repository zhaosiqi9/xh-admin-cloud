package com.xh.system.domain.service;

import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.constant.sysuser.SysUserConstant;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;
import com.xh.system.domain.repository.sysuser.factory.SysUserRepositoryFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 23:29
 */
@Service
public class SysUserDomainService {

    public static AbstractSysUserRepository getRepository(SysUserConstant.SysUserRootType type) {
        return SysUserRepositoryFactory.getRepository(type.getType());
    }

    public SysUserAggregate getRoot(Long rootId, SysUserConstant.SysUserRootType type) {
        return Optional.ofNullable(rootId).map(t -> getRepository(type).findByRootId(rootId)).orElse(null);
    }

    public SysUserAggregate getRootByLoginAccount(String loginAccount, boolean enable, SysUserConstant.SysUserRootType type) {
        return Optional.ofNullable(loginAccount).map(t -> getRepository(type).findByLoginAccount(loginAccount,  enable)).orElse(null);
    }

    public boolean updateUserInfo(SysUser sysUser) {
        return Optional.ofNullable(sysUser).map(t -> {
            SysUserAggregate root = new SysUserAggregate();
            root.setSysUser(t);
            getRepository(SysUserConstant.SysUserRootType.DEFAULT).update(root);
            return true;
        }).orElse(false);
    }
}
