package com.xh.system.domain.aggregate;


import cn.hutool.core.collection.CollUtil;
import com.xh.system.domain.entity.SysUserGroup;
import com.xh.system.domain.entity.SysUserGroupMember;
import lombok.Data;

import java.util.List;

@Data
public class SysUserGroupAggregate {
    
    private Long rootId;
    
    private SysUserGroup sysUserGroup;
    
    private List<SysUserGroupMember> sysUserGroupMemberList = CollUtil.newArrayList();
}
