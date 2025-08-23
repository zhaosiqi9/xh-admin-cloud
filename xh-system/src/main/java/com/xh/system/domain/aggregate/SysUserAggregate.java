package com.xh.system.domain.aggregate;

import cn.hutool.core.collection.CollUtil;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysUser;
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
}
