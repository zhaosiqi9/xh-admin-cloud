package com.xh.system.domain.repository.sysuser;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.core.utils.AssertUtil;
import com.xh.common.base.exception.MyException;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.constant.sysuser.SysUserConstant;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.entity.SysUserJob;
import com.xh.system.domain.mapstract.sysuser.SysUserEntity2POMapper;
import com.xh.system.domain.mapstract.sysuser.SysUserPO2EntityMapper;
import com.xh.system.domain.repository.sysuser.factory.SysUserRepositoryFactory;
import com.xh.system.infrastructure.mysql.po.SysUserJobPO;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import com.xh.system.infrastructure.mysql.service.SysOrgPOService;
import com.xh.system.infrastructure.mysql.service.SysRolePOService;
import com.xh.system.infrastructure.mysql.service.SysUserJobPOService;
import com.xh.system.infrastructure.mysql.service.SysUserPOService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

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
    private SysRolePOService sysRolePOService;

    @Resource
    private SysUserJobPOService sysUserJobPOService;

    @Resource
    private SysOrgPOService sysOrgPOService;

    @Resource
    private SysUserPO2EntityMapper sysUserPO2EntityMapper;

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
        SysUser sysUser = findMainByRootId(rootId);
        if (sysUser == null) {
            return null;
        }
        root.setSysUser(sysUser);
        root.setRootId(rootId);
        return root;
    }

    protected SysUser findMainByRootId(Long rootId) {
        SysUserPO sysUserPO = sysUserPOService.getById(rootId);
        if (sysUserPO == null) {
            return null;
        }
        return sysUserPO2EntityMapper.user2Entity(sysUserPO);
    }

    protected List<SysUserJob> findUserJobListByRootId(Long rootId) {
        List<SysUserJobPO> sysUserJobList = sysUserJobPOService.list(new LambdaQueryWrapper<SysUserJobPO>().eq(SysUserJobPO::getUserId, rootId));
        return sysUserPO2EntityMapper.userJob2EntityList(sysUserJobList);
    }

    protected List<SysRole> findUserRoleListByRootId(Long rootId, List<SysUserJob> userJobList) {
        if (CollUtil.isEmpty(userJobList)) {
            userJobList = findUserJobListByRootId(rootId);
        }
        List<Long> roleIdList = userJobList.stream().map(SysUserJob::getSysRoleId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        if (CollUtil.isEmpty(roleIdList)) {
            return CollUtil.newArrayList();
        }
        return sysUserPO2EntityMapper.userRole2EntityList(sysRolePOService.listByIds(roleIdList));
    }

    protected List<SysOrg> findUserOrgListByRootId(Long rootId, List<SysUserJob> userJobList) {
        if (CollUtil.isEmpty(userJobList)) {
            userJobList = findUserJobListByRootId(rootId);
        }
        List<Long> orgIdList = userJobList.stream().map(SysUserJob::getSysOrgId).filter(Objects::nonNull).distinct().collect(Collectors.toList());
        if (CollUtil.isEmpty(orgIdList)) {
            return CollUtil.newArrayList();
        }
        return sysUserPO2EntityMapper.userOrg2EntityList(sysOrgPOService.listByIds(orgIdList));
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
        root.setSysUser(sysUserPO2EntityMapper.user2Entity(sysUserPO));
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
            if (Optional.ofNullable(findByLoginAccount(sysUser.getCode(), sysUser.getEnabled())).isPresent()) {
                throw new MyException("用户账号%s已存在！".formatted(sysUser.getCode()));
            }
            AssertUtil.notBlank(sysUser.getCode(), "用户账号不能为空！");
            AssertUtil.notBlank(sysUser.getPassword(), "用户密码不能为空！");
            AssertUtil.notBlank(sysUser.getName(), "用户名称不能为空！");

            // 密码加密
            String pwHash = BCrypt.hashpw(sysUser.getPassword(), BCrypt.gensalt());
            sysUser.setPassword(pwHash);

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

    public Page<SysUserPO> query(String name, String code, long current, long size) {
        Page<SysUserPO> page = new Page<>(current, size);
        LambdaQueryWrapper<SysUserPO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.like(StrUtil.isNotBlank(name), SysUserPO::getName, name);
        lambdaQueryWrapper.like(StrUtil.isNotBlank(code), SysUserPO::getCode, code);
        return sysUserPOService.page(page, lambdaQueryWrapper);


    }
}
