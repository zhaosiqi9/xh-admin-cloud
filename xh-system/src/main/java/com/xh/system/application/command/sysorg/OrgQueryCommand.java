package com.xh.system.application.command.sysorg;

import cn.hutool.core.collection.CollUtil;
import com.github.yulichang.toolkit.StrUtils;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.xh.common.base.web.PageQuery;
import com.xh.system.api.request.OrgQueryRequest;
import com.xh.system.infrastructure.mysql.po.SysOrgPO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Schema(title = "组织查询参数")
@Accessors(chain = true)
public class OrgQueryCommand {


    public static MPJLambdaWrapper<SysOrgPO> initQueryWrapper(PageQuery<OrgQueryRequest> query) {
        MPJLambdaWrapper<SysOrgPO> lambdaQueryWrapper = new MPJLambdaWrapper<SysOrgPO>()
                .selectAll(SysOrgPO.class)
                .select("t1.name parent_name")
                .leftJoin("sys_org t1 on t1.id = t.parent_id")
                .eq(StrUtils.isNotBlank(query.getParam().getCode()), SysOrgPO::getCode, query.getParam().getCode())
                .eq(StrUtils.isNotBlank(query.getParam().getName()), SysOrgPO::getName, query.getParam().getName())
                .eq(StrUtils.isNotBlank(query.getParam().getParentId()), SysOrgPO::getParentId, query.getParam().getParentId())
                .eq(query.getParam().getEnabled() != null, SysOrgPO::getEnabled, query.getParam().getEnabled());
        wrapperConditionList(lambdaQueryWrapper, query.getFilters());
        return lambdaQueryWrapper;
    }

    private static <T> void wrapperConditionList(MPJLambdaWrapper<T> lambdaQueryWrapper, List<PageQuery.FilterRow> filterList) {
        if (CollUtil.isNotEmpty(filterList)) {
            filterList.forEach(filter -> {
                lambdaQueryWrapper.and(w1 -> {
                    wrapperCondition(w1, filter);
                });
            });
        }
    }

    private static <T> void wrapperCondition(MPJLambdaWrapper<T> w1, PageQuery.FilterRow filter) {
        if (filter.getLogic().equals("or")) {
            w1.or();
        }
        switch (filter.getCondition()) {
            case eq:
                w1.eqSql(filter.getProp(), (String) filter.getValue1());
                break;
            case ne:
                w1.ne(filter.getProp(), (String) filter.getValue1());
                break;
            case gt:
                w1.gt(filter.getProp(), (String) filter.getValue1());
                break;
            case ge:
                w1.ge(filter.getProp(), (String) filter.getValue1());
                break;
            case lt:
                w1.lt(filter.getProp(), (String) filter.getValue1());
                break;
            case le:
                w1.le(filter.getProp(), (String) filter.getValue1());
                break;
        }
        if (filter.getChildren() != null) {
            filter.getChildren().forEach(filter1 -> {
                wrapperCondition(w1, filter1);
            });
        }
    }
}
