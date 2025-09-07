package com.xh.system.domain.repository.sysusergroup;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xh.common.base.constant.SysUserGroupConstant;
import com.xh.system.infrastructure.mysql.po.SysUserGroupMemberPO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserGroupWithMemberRepositoryImpl extends AbstractSysUserGroupRepository {
    @Override
    protected SysUserGroupConstant.UserGroupMemberRootType getType() {
        return SysUserGroupConstant.UserGroupMemberRootType.MEMBER;
    }

    @Override
    public void delUserGroup(List<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return;
        }
        getSysUserGroupMemberPOService().removeBatchByIds(ids);

        LambdaQueryWrapper<SysUserGroupMemberPO> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SysUserGroupMemberPO::getSysUserGroupId, ids);
        getSysUserGroupMemberPOService().remove(lambdaQueryWrapper);
    }
}
