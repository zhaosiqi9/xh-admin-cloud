package com.xh.system.domain.service;

import cn.dev33.satoken.secure.BCrypt;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.repository.sysuser.AbstractSysUserRepository;
import com.xh.system.domain.repository.sysuser.factory.SysUserRepositoryFactory;
import org.springframework.stereotype.Service;

import java.util.List;
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
        return Optional.ofNullable(loginAccount).map(t -> getRepository(type).findByLoginAccount(loginAccount, enable)).orElse(null);
    }

    public void clearFailuresNum(SysUserAggregate root, Long rootId, SysUserConstant.SysUserRootType type) {
        root = Optional.ofNullable(root).orElse(getRoot(rootId, type));
        SysUser sysUser = root.getSysUser();
        sysUser.setFailuresNum(0);
        sysUser.setLockMsg(null);

        SysUserAggregate newRoot = new SysUserAggregate();
        newRoot.setRootId(sysUser.getId());
        newRoot.setSysUser(sysUser);

        getRepository(type).update(newRoot);
    }

    public void loginFailUpdateInfo(SysUserAggregate root,
                                    Long rootId,
                                    Integer failuresNum,
                                    Integer status,
                                    String lockMsg,
                                    SysUserConstant.SysUserRootType type) {
        root = Optional.ofNullable(root).orElse(getRoot(rootId, type));
        SysUser sysUser = Optional.ofNullable(root.getSysUser()).orElseThrow(() -> new RuntimeException("用户不存在"));
        sysUser.setFailuresNum(failuresNum);
        sysUser.setStatus(status);
        sysUser.setLockMsg(lockMsg);

        SysUserAggregate newRoot = new SysUserAggregate();
        newRoot.setRootId(sysUser.getId());
        newRoot.setSysUser(sysUser);
        getRepository(type).update(newRoot);
    }

    public SysUser saveSysUser(SysUser sysUser) {
        return Optional.ofNullable(sysUser).map(t -> {
            SysUserAggregate root = new SysUserAggregate();
            sysUser.setId(IdUtil.getSnowflakeNextId());
            root.setSysUser(sysUser);
            root.setRootId(sysUser.getId());
            getRepository(SysUserConstant.SysUserRootType.DEFAULT).save(root);
            return sysUser;
        }).orElse(null);
    }

    public boolean delUserByIds(List<Long> userIds) {
        if (CollUtil.isEmpty(userIds)) {
            return false;
        }
        userIds.parallelStream().forEach(t -> {
            getRepository(SysUserConstant.SysUserRootType.ORG_ROLE).delete(t);
        });
        return true;
    }

    public void resetPassword(SysUserAggregate root, Long id, String password) {
        root = Optional.ofNullable(Optional.ofNullable(root).orElse(getRoot(id, SysUserConstant.SysUserRootType.DEFAULT))).orElseThrow(() -> new RuntimeException("用户不存在"));
        SysUser user = Optional.ofNullable(root.getSysUser()).orElseThrow(() -> new RuntimeException("用户不存在"));
        // 密码加密
        String pwHash = BCrypt.hashpw(password, BCrypt.gensalt());
        user.setPassword(pwHash);
        getRepository(SysUserConstant.SysUserRootType.DEFAULT).update(root);
    }
}
