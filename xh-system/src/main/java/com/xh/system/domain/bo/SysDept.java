package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 部门表
* @TableName sys_dept
*/
public class SysDept implements Serializable {

    /**
    * 部门id
    */
    
    
    private Long dept_id;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 父部门id
    */
    
    private Long parent_id;
    /**
    * 祖级列表
    */
    
    
    
    private String ancestors;
    /**
    * 部门名称
    */
    
    
    
    private String dept_name;
    /**
    * 部门类别编码
    */
    
    
    
    private String dept_category;
    /**
    * 显示顺序
    */
    
    private Integer order_num;
    /**
    * 负责人
    */
    
    private Long leader;
    /**
    * 联系电话
    */
    
    
    
    private String phone;
    /**
    * 邮箱
    */
    
    
    
    private String email;
    /**
    * 部门状态（0正常 1停用）
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
    * 部门id
    */
    private void setDept_id(Long dept_id){
    this.dept_id = dept_id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 父部门id
    */
    private void setParent_id(Long parent_id){
    this.parent_id = parent_id;
    }

    /**
    * 祖级列表
    */
    private void setAncestors(String ancestors){
    this.ancestors = ancestors;
    }

    /**
    * 部门名称
    */
    private void setDept_name(String dept_name){
    this.dept_name = dept_name;
    }

    /**
    * 部门类别编码
    */
    private void setDept_category(String dept_category){
    this.dept_category = dept_category;
    }

    /**
    * 显示顺序
    */
    private void setOrder_num(Integer order_num){
    this.order_num = order_num;
    }

    /**
    * 负责人
    */
    private void setLeader(Long leader){
    this.leader = leader;
    }

    /**
    * 联系电话
    */
    private void setPhone(String phone){
    this.phone = phone;
    }

    /**
    * 邮箱
    */
    private void setEmail(String email){
    this.email = email;
    }

    /**
    * 部门状态（0正常 1停用）
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
    * 部门id
    */
    private Long getDept_id(){
    return this.dept_id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 父部门id
    */
    private Long getParent_id(){
    return this.parent_id;
    }

    /**
    * 祖级列表
    */
    private String getAncestors(){
    return this.ancestors;
    }

    /**
    * 部门名称
    */
    private String getDept_name(){
    return this.dept_name;
    }

    /**
    * 部门类别编码
    */
    private String getDept_category(){
    return this.dept_category;
    }

    /**
    * 显示顺序
    */
    private Integer getOrder_num(){
    return this.order_num;
    }

    /**
    * 负责人
    */
    private Long getLeader(){
    return this.leader;
    }

    /**
    * 联系电话
    */
    private String getPhone(){
    return this.phone;
    }

    /**
    * 邮箱
    */
    private String getEmail(){
    return this.email;
    }

    /**
    * 部门状态（0正常 1停用）
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
