package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 租户套餐表
* @TableName sys_tenant_package
*/
public class SysTenantPackage implements Serializable {

    /**
    * 租户套餐id
    */
    
    
    private Long package_id;
    /**
    * 套餐名称
    */
    
    
    
    private String package_name;
    /**
    * 关联菜单id
    */
    
    
    
    private String menu_ids;
    /**
    * 备注
    */
    
    
    
    private String remark;
    /**
    * 菜单树选择项是否关联显示
    */
    
    private Integer menu_check_strictly;
    /**
    * 状态（0正常 1停用）
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
    * 租户套餐id
    */
    private void setPackage_id(Long package_id){
    this.package_id = package_id;
    }

    /**
    * 套餐名称
    */
    private void setPackage_name(String package_name){
    this.package_name = package_name;
    }

    /**
    * 关联菜单id
    */
    private void setMenu_ids(String menu_ids){
    this.menu_ids = menu_ids;
    }

    /**
    * 备注
    */
    private void setRemark(String remark){
    this.remark = remark;
    }

    /**
    * 菜单树选择项是否关联显示
    */
    private void setMenu_check_strictly(Integer menu_check_strictly){
    this.menu_check_strictly = menu_check_strictly;
    }

    /**
    * 状态（0正常 1停用）
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
    * 租户套餐id
    */
    private Long getPackage_id(){
    return this.package_id;
    }

    /**
    * 套餐名称
    */
    private String getPackage_name(){
    return this.package_name;
    }

    /**
    * 关联菜单id
    */
    private String getMenu_ids(){
    return this.menu_ids;
    }

    /**
    * 备注
    */
    private String getRemark(){
    return this.remark;
    }

    /**
    * 菜单树选择项是否关联显示
    */
    private Integer getMenu_check_strictly(){
    return this.menu_check_strictly;
    }

    /**
    * 状态（0正常 1停用）
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

}
