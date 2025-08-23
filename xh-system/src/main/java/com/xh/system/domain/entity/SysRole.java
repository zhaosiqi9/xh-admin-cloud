package com.xh.system.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author : gr
 * @version 1.0.0
 * @since : 2025/8/23 09:10
 */
@Data
public class SysRole {
    @Schema(title = "主键ID")
    protected Long id;
    
    @Schema(title = "用户代码")
    private String code;
    
    @Schema(title = "用户名")
    private String name;
    
    @Schema(title = "密码")
    private String password;
    
    @Schema(title = "头像")
    private String avatar;
    
    @Schema(title = "手机号码")
    private String telephone;
    
    @Schema(title = "状态（1：正常，2：锁定）")
    private Integer status;
    
    @Schema(title = "登录失败的次数")
    private Integer failuresNum;
    
    @Schema(title = "账号锁定的原因")
    private String lockMsg;
    
    @Schema(title = "允许重复登录")
    private Boolean allowRepeat;
    
    @Schema(title = "自动续签，请求会自动延长token失效时间")
    private Boolean autoRenewal;
    
    @Schema(title = "是否演示账号")
    private Boolean isDemo;
    
    @Schema(title = "角色排序")
    private String roleSorter;
    
    @Schema(title = "是否启用")
    private Boolean enabled;
    
    @Schema(title = "创建时间")
    private LocalDateTime createTime;

    @Schema(title = "修改时间")
    private LocalDateTime updateTime;

    @Schema(title = "创建人")
    private Integer createBy;

    @Schema(title = "修改人")
    private Integer updateBy;

    @Schema(title = "是否已删除")
    private Boolean deleted;
}
