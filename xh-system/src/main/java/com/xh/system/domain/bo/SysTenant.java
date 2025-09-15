package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 租户表
* @TableName sys_tenant
*/
public class SysTenant implements Serializable {

    /**
    * id
    */
    
    
    private Long id;
    /**
    * 租户编号
    */
    
    
    
    
    private String tenant_id;
    /**
    * 联系人
    */
    
    
    
    private String contact_user_name;
    /**
    * 联系电话
    */
    
    
    
    private String contact_phone;
    /**
    * 企业名称
    */
    
    
    
    private String company_name;
    /**
    * 统一社会信用代码
    */
    
    
    
    private String license_number;
    /**
    * 地址
    */
    
    
    
    private String address;
    /**
    * 企业简介
    */
    
    
    
    private String intro;
    /**
    * 域名
    */
    
    
    
    private String domain;
    /**
    * 备注
    */
    
    
    
    private String remark;
    /**
    * 租户套餐编号
    */
    
    private Long package_id;
    /**
    * 过期时间
    */
    
    private Date expire_time;
    /**
    * 用户数量（-1不限制）
    */
    
    private Integer account_count;
    /**
    * 租户状态（0正常 1停用）
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
    * id
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 联系人
    */
    private void setContact_user_name(String contact_user_name){
    this.contact_user_name = contact_user_name;
    }

    /**
    * 联系电话
    */
    private void setContact_phone(String contact_phone){
    this.contact_phone = contact_phone;
    }

    /**
    * 企业名称
    */
    private void setCompany_name(String company_name){
    this.company_name = company_name;
    }

    /**
    * 统一社会信用代码
    */
    private void setLicense_number(String license_number){
    this.license_number = license_number;
    }

    /**
    * 地址
    */
    private void setAddress(String address){
    this.address = address;
    }

    /**
    * 企业简介
    */
    private void setIntro(String intro){
    this.intro = intro;
    }

    /**
    * 域名
    */
    private void setDomain(String domain){
    this.domain = domain;
    }

    /**
    * 备注
    */
    private void setRemark(String remark){
    this.remark = remark;
    }

    /**
    * 租户套餐编号
    */
    private void setPackage_id(Long package_id){
    this.package_id = package_id;
    }

    /**
    * 过期时间
    */
    private void setExpire_time(Date expire_time){
    this.expire_time = expire_time;
    }

    /**
    * 用户数量（-1不限制）
    */
    private void setAccount_count(Integer account_count){
    this.account_count = account_count;
    }

    /**
    * 租户状态（0正常 1停用）
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
    * id
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 联系人
    */
    private String getContact_user_name(){
    return this.contact_user_name;
    }

    /**
    * 联系电话
    */
    private String getContact_phone(){
    return this.contact_phone;
    }

    /**
    * 企业名称
    */
    private String getCompany_name(){
    return this.company_name;
    }

    /**
    * 统一社会信用代码
    */
    private String getLicense_number(){
    return this.license_number;
    }

    /**
    * 地址
    */
    private String getAddress(){
    return this.address;
    }

    /**
    * 企业简介
    */
    private String getIntro(){
    return this.intro;
    }

    /**
    * 域名
    */
    private String getDomain(){
    return this.domain;
    }

    /**
    * 备注
    */
    private String getRemark(){
    return this.remark;
    }

    /**
    * 租户套餐编号
    */
    private Long getPackage_id(){
    return this.package_id;
    }

    /**
    * 过期时间
    */
    private Date getExpire_time(){
    return this.expire_time;
    }

    /**
    * 用户数量（-1不限制）
    */
    private Integer getAccount_count(){
    return this.account_count;
    }

    /**
    * 租户状态（0正常 1停用）
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
