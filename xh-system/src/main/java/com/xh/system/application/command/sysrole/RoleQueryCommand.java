package com.xh.system.application.command.sysrole;


import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.xh.common.base.web.PageQuery;
import com.xh.system.api.request.RoleQueryRequest;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.infrastructure.mysql.po.SysRolePO;

import static com.xh.mybatis.util.MybatisUtil.wrapperConditionList;

public class RoleQueryCommand {
    
    public static MPJLambdaWrapper<SysRolePO> initQueryWrapper(PageQuery<RoleQueryRequest> query) {
        RoleQueryRequest request = query.getParam();
        MPJLambdaWrapper<SysRolePO> lambdaWrapper = new MPJLambdaWrapper<SysRolePO>()
                .eq(request.getId() != null, SysRole::getId, request.getId())
                .eq(request.getCode() != null, SysRole::getCode, request.getCode())
                .eq(request.getName() != null, SysRole::getName, request.getName())
                .eq(request.getPassword() != null, SysRole::getPassword, request.getPassword())
                .eq(request.getAvatar() != null, SysRole::getAvatar, request.getAvatar());
        wrapperConditionList(lambdaWrapper, query.getFilters());
        return lambdaWrapper;
    }
    
}
