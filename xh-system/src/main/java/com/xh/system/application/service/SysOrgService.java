package com.xh.system.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xh.common.base.constant.SysUserConstant;
import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.system.api.request.OrgQueryRequest;
import com.xh.system.api.response.OrgQueryResponse;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.service.SysUserDomainService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SysOrgService {
    @Resource
    private SysUserDomainService sysUserDomainService;

    public PageResult<OrgQueryResponse> query(PageQuery<OrgQueryRequest> query) {
        Page<SysOrg> orgPage = SysUserDomainService.getRepository(SysUserConstant.SysUserRootType.ORG).sysOrgPageQuery(query.getCurrentPage(), query.getPageSize(), null);
        return null;
    }
}
