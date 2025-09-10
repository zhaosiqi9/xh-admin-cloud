package com.xh.system.infrastructure.mysql.mapper;

import com.github.yulichang.base.MPJBaseMapper;
import com.xh.common.jwt.dto.SysOrgRoleDTO;
import com.xh.system.infrastructure.mysql.po.SysUserPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/22 16:47
 */
@Mapper
public interface SysUserPOMapper extends MPJBaseMapper<SysUserPO> {

    @Select("""
            select
                           tem.*,
                              o.code org_code,
                               o.name org_name,
                              r.name role_name
                       from (
                           SELECT
                               sys_org_id, sys_role_id
                           FROM
                               sys_user_job
                           WHERE
                              type = 1 AND enabled is true AND user_id = #{userId}
                           UNION
                               SELECT
                               c.sys_org_id, c.sys_role_id
                           FROM
                               sys_user_group_member a
                               LEFT JOIN sys_user_group b ON b.id = a.sys_user_group_id
                               LEFT JOIN sys_user_job c ON b.id = c.user_id AND c.type = 2 AND c.enabled is true
                           WHERE
                               a.sys_user_id = #{userId}
                       ) tem
                           left join sys_org o on o.id = tem.sys_org_id
                       left join sys_role r on r.id = tem.sys_role_id
            """)
    List<SysOrgRoleDTO> getUserRoles(@Param("userId") Long userId);
}
