package com.xh.system.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.system.api.request.OrgQueryRequest;
import com.xh.system.api.response.OrgQueryResponse;
import com.xh.system.application.command.sysorg.OrgQueryCommand;
import com.xh.system.application.mapstract.SysOrgEntity2ResponseMapper;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.service.SysUserDomainService;
import com.xh.system.infrastructure.mysql.po.SysOrgPO;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgService {
    @Resource
    private SysUserDomainService sysUserDomainService;

    public PageResult<OrgQueryResponse> query(PageQuery<OrgQueryRequest> query) {
        MPJLambdaWrapper<SysOrgPO> lambdaWrapper = OrgQueryCommand.initQueryWrapper(query);
        Page<SysOrg> orgPage = SysUserDomainService.getRepository(SysUserConstant.SysUserRootType.ORG).sysOrgPageQuery(query.getCurrentPage(), query.getPageSize(), lambdaWrapper);
        return SysOrgEntity2ResponseMapper.INSTANCE.pageEntity2PageResult(orgPage);
    }

    public PageResult<SysOrg> queryOrgTree(String name) {
        return null;
    }

    public void del(List<Long> ids) {
        
    }

    public SysOrg save(SysOrg sysOrg) {
        return null;
    }

    public SysOrg getById(Long id) {
        return null;
    }
}
