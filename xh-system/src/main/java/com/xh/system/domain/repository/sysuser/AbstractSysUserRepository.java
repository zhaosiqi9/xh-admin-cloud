package com.xh.system.domain.repository.sysuser;

import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.constant.sysuser.SysUserConstant;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.mapstract.sysuser.SysUserEntity2POMapper;
import com.xh.system.domain.mapstract.sysuser.SysUserPOEntityMapper;
import com.xh.system.domain.repository.sysuser.factory.SysUserRepositoryFactory;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import com.xh.system.infrastructure.mysql.service.SysUserPOService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 17:00
 */
@Slf4j
@Getter
public abstract class AbstractSysUserRepository {

    @Resource
    private SysUserPOService sysUserPOService;

    @Resource
    private SysUserPOEntityMapper sysUserPOEntityMapper;

    @Resource
    private SysUserEntity2POMapper sysUserEntity2POMapper;


    protected abstract SysUserConstant.SysUserRootType getType();

    @PostConstruct
    protected void init() {
        SysUserRepositoryFactory.SYS_USER_REPOSITORY_MAP.put(getType().getType(), this);
    }

    public SysUserAggregate findByRootId(Long rootId) {
        if (rootId == null) {
            return null;
        }
        SysUserAggregate root = new SysUserAggregate();
        SysUserPO sysUserPO = sysUserPOService.getById(rootId);
        if (sysUserPO == null) {
            return null;
        }
        root.setSysUser(sysUserPOEntityMapper.toEntity(sysUserPO));
        root.setRootId(rootId);
        return root;
    }

    public SysUserAggregate findByLoginAccount(String loginAccount, boolean enable) {
        if (loginAccount == null) {
            return null;
        }
        SysUserPO sysUserPO = sysUserPOService.findByLoginAccount(loginAccount, enable);

        if (sysUserPO == null) {
            return null;
        }
        SysUserAggregate root = new SysUserAggregate();
        root.setSysUser(sysUserPOEntityMapper.toEntity(sysUserPO));
        root.setRootId(sysUserPO.getId());
        return root;
    }

    public SysUserAggregate save(SysUserAggregate root) {
        return Optional.of(root).map(t -> {
            Long rootId = saveSysUser(t.getSysUser());
            t.setRootId(rootId);
            return t;
        }).orElse(null);

    }

    public SysUserAggregate update(SysUserAggregate root) {
        return Optional.of(root).map(t -> {
            updateSysUser(t.getSysUser());
            return t;
        }).orElse(null);
    }

    public boolean delete(Long rootId) {
        boolean deleteSysUser = deleteSysUser(rootId);
        return deleteSysUser;
    }

    protected Long saveSysUser(SysUser sysUser) {
        return Optional.of(sysUser).map(t -> {
            SysUserPO record = sysUserEntity2POMapper.toRecord(t);
            sysUserPOService.save(record);
            record.setId(record.getId());
            return record.getId();
        }).orElse(null);
    }

    protected void updateSysUser(SysUser sysUser) {
        Optional.of(sysUser).map(t -> {
            SysUserPO record = sysUserEntity2POMapper.toRecord(t);
            sysUserPOService.updateById(record);
            record.setId(record.getId());
            return record.getId();
        });
    }

    private boolean deleteSysUser(Long rootId) {
        return Optional.ofNullable(rootId).map(t -> sysUserPOService.removeById(t)).orElse(false);
    }
}
