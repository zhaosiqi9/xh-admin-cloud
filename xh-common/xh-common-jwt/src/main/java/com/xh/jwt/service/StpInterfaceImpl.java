package com.xh.jwt.service;

import cn.dev33.satoken.stp.StpInterface;
import cn.hutool.extra.spring.SpringUtil;
import com.xh.common.core.api.contract.RemotePermissionContract;

import java.util.List;

/**
 * 自定义权限加载接口实现类
 */
public class StpInterfaceImpl implements StpInterface {

    /**
     * 获取权限列表
     * @param loginId  账号id
     * @param loginType 账号类型
     * @return List<String>
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        RemotePermissionContract permissionService = SpringUtil.getBean(RemotePermissionContract.class);
        return permissionService.getPermissionList((Long) loginId, loginType);
    }

    /**
     * 获取菜单权限列表
     * @param loginId  账号id
     * @param loginType 账号类型
     * @return List<String>
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        RemotePermissionContract permissionService = SpringUtil.getBean(RemotePermissionContract.class);
        return permissionService.getRoleList((Long) loginId, loginType);
    }
}
