package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 角色信息表
* @TableName sys_role
*/
public class SysRole implements Serializable {

    /**
    * 角色ID
    */
    
    
    private Long role_id;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 角色名称
    */
    
    
    
    
    private String role_name;
    /**
    * 角色权限字符串
    */
    
    
    
    
    private String role_key;
    /**
    * 显示顺序
    */
    
    
    private Integer role_sort;
    /**
    * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5：仅本人数据权限 6：部门及以下或本人数据权限）
    */
    
    private String data_scope;
    /**
    * 菜单树选择项是否关联显示
    */
    
    private Integer menu_check_strictly;
    /**
    * 部门树选择项是否关联显示
    */
    
    private Integer dept_check_strictly;
    /**
    * 角色状态（0正常 1停用）
    */
    
    
    private String status;
    /**
    * 删除标志（0代表存在 2代表删除）
    */
    
    private String del_flag;
    /**
    * 创建部门
    */
    
    private Long create_dept;
    /**
    * 创建者
    */
    
    private Long create_by;
    /**
    * 创建时间
    */
    
    private Date create_time;
    /**
    * 更新者
    */
    
    private Long update_by;
    /**
    * 更新时间
    */
    
    private Date update_time;
    /**
    * 备注
    */
    
    
    
    private String remark;

    /**
    * 角色ID
    */
    private void setRole_id(Long role_id){
    this.role_id = role_id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 角色名称
    */
    private void setRole_name(String role_name){
    this.role_name = role_name;
    }

    /**
    * 角色权限字符串
    */
    private void setRole_key(String role_key){
    this.role_key = role_key;
    }

    /**
    * 显示顺序
    */
    private void setRole_sort(Integer role_sort){
    this.role_sort = role_sort;
    }

    /**
    * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5：仅本人数据权限 6：部门及以下或本人数据权限）
    */
    private void setData_scope(String data_scope){
    this.data_scope = data_scope;
    }

    /**
    * 菜单树选择项是否关联显示
    */
    private void setMenu_check_strictly(Integer menu_check_strictly){
    this.menu_check_strictly = menu_check_strictly;
    }

    /**
    * 部门树选择项是否关联显示
    */
    private void setDept_check_strictly(Integer dept_check_strictly){
    this.dept_check_strictly = dept_check_strictly;
    }

    /**
    * 角色状态（0正常 1停用）
    */
    private void setStatus(String status){
    this.status = status;
    }

    /**
    * 删除标志（0代表存在 2代表删除）
    */
    private void setDel_flag(String del_flag){
    this.del_flag = del_flag;
    }

    /**
    * 创建部门
    */
    private void setCreate_dept(Long create_dept){
    this.create_dept = create_dept;
    }

    /**
    * 创建者
    */
    private void setCreate_by(Long create_by){
    this.create_by = create_by;
    }

    /**
    * 创建时间
    */
    private void setCreate_time(Date create_time){
    this.create_time = create_time;
    }

    /**
    * 更新者
    */
    private void setUpdate_by(Long update_by){
    this.update_by = update_by;
    }

    /**
    * 更新时间
    */
    private void setUpdate_time(Date update_time){
    this.update_time = update_time;
    }

    /**
    * 备注
    */
    private void setRemark(String remark){
    this.remark = remark;
    }


    /**
    * 角色ID
    */
    private Long getRole_id(){
    return this.role_id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 角色名称
    */
    private String getRole_name(){
    return this.role_name;
    }

    /**
    * 角色权限字符串
    */
    private String getRole_key(){
    return this.role_key;
    }

    /**
    * 显示顺序
    */
    private Integer getRole_sort(){
    return this.role_sort;
    }

    /**
    * 数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限 5：仅本人数据权限 6：部门及以下或本人数据权限）
    */
    private String getData_scope(){
    return this.data_scope;
    }

    /**
    * 菜单树选择项是否关联显示
    */
    private Integer getMenu_check_strictly(){
    return this.menu_check_strictly;
    }

    /**
    * 部门树选择项是否关联显示
    */
    private Integer getDept_check_strictly(){
    return this.dept_check_strictly;
    }

    /**
    * 角色状态（0正常 1停用）
    */
    private String getStatus(){
    return this.status;
    }

    /**
    * 删除标志（0代表存在 2代表删除）
    */
    private String getDel_flag(){
    return this.del_flag;
    }

    /**
    * 创建部门
    */
    private Long getCreate_dept(){
    return this.create_dept;
    }

    /**
    * 创建者
    */
    private Long getCreate_by(){
    return this.create_by;
    }

    /**
    * 创建时间
    */
    private Date getCreate_time(){
    return this.create_time;
    }

    /**
    * 更新者
    */
    private Long getUpdate_by(){
    return this.update_by;
    }

    /**
    * 更新时间
    */
    private Date getUpdate_time(){
    return this.update_time;
    }

    /**
    * 备注
    */
    private String getRemark(){
    return this.remark;
    }

}
