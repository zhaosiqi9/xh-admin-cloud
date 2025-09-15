package com.xh.system.application.service;

import com.xh.common.base.web.PageQuery;
import com.xh.common.base.web.PageResult;
import com.xh.system.api.request.client.SysClientBo;
import com.xh.system.api.response.client.SysClientVo;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @date : 2025/9/15 16:49
 */
@Service
public class ISysClientService {

    public PageResult<SysClientVo> queryPageList(SysClientBo bo, PageQuery pageQuery) {
        return null;
    }

    public List<SysClientVo> queryList(SysClientBo bo) {
        return null;
    }

    public SysClientVo queryById(@NotNull(message = "主键不能为空") Long id) {
        return null;
    }

    public Void insertByBo(SysClientBo bo) {
        return null;
    }

    public Void updateByBo(SysClientBo bo) {
        return null;
    }

    public Void updateByBo(String clientId, String status) {
        return null;
    }

    public Void deleteWithValidByIds(List<Long> ids, boolean bool) {
        return null;
    }
}
