package com.xh.mybatis.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.github.yulichang.wrapper.MPJLambdaWrapper;
import com.xh.common.base.web.PageQuery;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @date : 2025/9/5 00:20
 */
public class MybatisUtil {
    
    public static <T> void wrapperConditionList(MPJLambdaWrapper<T> lambdaQueryWrapper, List<PageQuery.FilterRow> filterList) {
        if (CollUtil.isNotEmpty(filterList)) {
            filterList.forEach(filter -> {
                lambdaQueryWrapper.and(w1 -> {
                    wrapperCondition(w1, filter);
                });
            });
        }
    }

    public static <T> void wrapperCondition(MPJLambdaWrapper<T> w1, PageQuery.FilterRow filter) {
        if (filter.getLogic().equals("or")) {
            w1.or();
        }
        String prop = "t."+ StrUtil.toUnderlineCase(filter.getProp());
        switch (filter.getCondition()) {
            case eq:
                w1.eqSql(prop, (String) filter.getValue1());
                break;
            case ne:
                w1.ne(prop, (String) filter.getValue1());
                break;
            case gt:
                w1.gt(prop, (String) filter.getValue1());
                break;
            case ge:
                w1.ge(prop, (String) filter.getValue1());
                break;
            case lt:
                w1.lt(prop, (String) filter.getValue1());
                break;
            case le:
                w1.le(prop, (String) filter.getValue1());
                break;
            case ct:
                w1.in(prop, filter.getValue1());
                break;
        }
        if (filter.getChildren() != null) {
            filter.getChildren().forEach(filter1 -> {
                wrapperCondition(w1, filter1);
            });
        }
    }
    
}
