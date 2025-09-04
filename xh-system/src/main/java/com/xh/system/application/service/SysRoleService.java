package com.xh.system.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.system.api.request.RoleQueryRequest;
import com.xh.system.api.response.RoleQueryResponse;
import com.xh.system.application.command.sysrole.RoleQueryCommand;
import com.xh.system.application.mapstract.SysOrgEntity2ResponseMapper;
import com.xh.system.application.mapstract.SysRoleEntity2ResponseMapper;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.service.SysUserDomainService;
import com.xh.system.infrastructure.mysql.po.SysRolePO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysRoleService {

    @Resource
    private SysUserDomainService sysUserDomainService;
    
    public PageResult<RoleQueryResponse> query(PageQuery<RoleQueryRequest> request) {
        MPJLambdaWrapper<SysRolePO> lambdaWrapper = RoleQueryCommand.initQueryWrapper(request);
        
        Page<SysRole> rolePage = SysUserDomainService.getRepository(SysUserConstant.SysUserRootType.ROLE).sysRolePageQuery(request.getCurrentPage(),
                request.getPageSize(), lambdaWrapper);
        return SysRoleEntity2ResponseMapper.INSTANCE.pageEntity2PageResult(rolePage);
        
    }
}
