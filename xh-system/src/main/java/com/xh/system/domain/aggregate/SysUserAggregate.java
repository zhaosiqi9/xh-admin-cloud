package com.xh.system.domain.aggregate;

import cn.hutool.core.collection.CollUtil;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.entity.SysUserJob;
import lombok.Data;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 16:54
 */
@Data
public class SysUserAggregate {

    private Long rootId;

    private SysUser sysUser;

    private List<SysRole> sysRoleList = CollUtil.newArrayList();

    private List<SysUserJob> sysUserJobList = CollUtil.newArrayList();

    private List<SysOrg> sysOrgList = CollUtil.newArrayList();
}
