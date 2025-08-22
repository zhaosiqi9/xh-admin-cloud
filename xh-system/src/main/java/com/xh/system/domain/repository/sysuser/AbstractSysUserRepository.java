package com.xh.system.domain.repository.sysuser;

import com.xh.common.core.entity.SysUserRecord;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.constant.SysUserConstant;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.mapstract.sysuser.SysUserEntity2RecordMapper;
import com.xh.system.domain.mapstract.sysuser.SysUserRecord2EntityMapper;
import com.xh.system.domain.repository.sysuser.factory.SysUserRepositoryFactory;
import com.xh.system.infrastructure.mysql.service.SysUserRecordService;
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
    private SysUserRecordService sysUserRecordService;

    @Resource
    private SysUserRecord2EntityMapper sysUserRecord2EntityMapper;

    @Resource
    private SysUserEntity2RecordMapper sysUserEntity2RecordMapper;


    protected abstract SysUserConstant getType();

    @PostConstruct
    protected void init() {
        SysUserRepositoryFactory.SYS_USER_REPOSITORY_MAP.put(getType().getValue(), this);
    }

    public SysUserAggregate findByRootId(Long rootId) {
        if (rootId == null) {
            return null;
        }
        SysUserAggregate root = new SysUserAggregate();
        SysUserRecord sysUserRecord = sysUserRecordService.getById(rootId);
        if (sysUserRecord == null) {
            return null;
        }
        root.setSysUser(sysUserRecord2EntityMapper.toEntity(sysUserRecord));
        root.setRootId(rootId);
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
            SysUserRecord record = sysUserEntity2RecordMapper.toRecord(t);
            sysUserRecordService.save(record);
            record.setId(record.getId());
            return record.getId();
        }).orElse(null);
    }

    protected void updateSysUser(SysUser sysUser) {
        Optional.of(sysUser).map(t -> {
            SysUserRecord record = sysUserEntity2RecordMapper.toRecord(t);
            sysUserRecordService.updateById(record);
            record.setId(record.getId());
            return record.getId();
        });
    }

    private boolean deleteSysUser(Long rootId) {
        return Optional.ofNullable(rootId).map(t -> sysUserRecordService.removeById(t)).orElse(false);
    }

}
