package com.xh.system.application.command.sysorg;

import com.github.yulichang.toolkit.StrUtils;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.xh.common.base.web.PageQuery;
import com.xh.system.api.request.OrgQueryRequest;
import com.xh.system.infrastructure.mysql.po.SysOrgPO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import static com.xh.mybatis.util.MybatisUtil.wrapperConditionList;

@Data
@Schema(title = "组织查询参数")
@Accessors(chain = true)
public class OrgQueryCommand {


    public static MPJLambdaWrapper<SysOrgPO> initQueryWrapper(PageQuery<OrgQueryRequest> query) {
        MPJLambdaWrapper<SysOrgPO> lambdaWrapper = new MPJLambdaWrapper<SysOrgPO>()
                .selectAll(SysOrgPO.class)
                .select("t1.name parent_name")
                .leftJoin("sys_org t1 on t1.id = t.parent_id")
                .like(StrUtils.isNotBlank(query.getParam().getCode()), SysOrgPO::getCode, query.getParam().getCode())
                .like(StrUtils.isNotBlank(query.getParam().getName()), SysOrgPO::getName, query.getParam().getName())
                .like(StrUtils.isNotBlank(query.getParam().getParentId()), SysOrgPO::getParentId, query.getParam().getParentId())
                .eq(query.getParam().getEnabled() != null, SysOrgPO::getEnabled, query.getParam().getEnabled());
        wrapperConditionList(lambdaWrapper, query.getFilters());
        return lambdaWrapper;
    }


}
