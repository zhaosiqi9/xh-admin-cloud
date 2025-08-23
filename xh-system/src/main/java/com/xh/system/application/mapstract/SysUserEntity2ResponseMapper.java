package com.xh.system.application.mapstract;

import com.xh.system.api.response.*;
import com.xh.system.domain.aggregate.SysUserAggregate;
import com.xh.system.domain.entity.SysOrg;
import com.xh.system.domain.entity.SysRole;
import com.xh.system.domain.entity.SysUser;
import com.xh.system.domain.entity.SysUserJob;
import lombok.val;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 09:23
 */
@Mapper(componentModel = "spring")
public interface SysUserEntity2ResponseMapper {

    SysUserEntity2ResponseMapper INSTANCE = Mappers.getMapper(SysUserEntity2ResponseMapper.class);

    default GetUserInfoResponse toGetUserInfoResponse(SysUserAggregate root) {
        val response = new GetUserInfoResponse();
        response.setUser(toGetUserInfoResponseUser(root.getSysUser()));
        response.setJobList(toGetUserInfoResponseJobList(root.getSysUserJobList()));
        response.setOrgList(toGetUserInfoResponseOrgList(root.getSysOrgList()));
        response.setRoleList(toGetUserInfoResponseRoleList(root.getSysRoleList()));
        return response;
    }

    GetUserInfoResponseUser toGetUserInfoResponseUser(SysUser sysUser);

    List<GetUserInfoResponseJob> toGetUserInfoResponseJobList(List<SysUserJob> userJobList);

    List<GetUserInfoResponseOrg> toGetUserInfoResponseOrgList(List<SysOrg> sysOrgList);

    List<GetUserInfoResponseRole> toGetUserInfoResponseRoleList(List<SysRole> sysRoleList);

}
