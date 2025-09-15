package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 用户信息表
* @TableName sys_user
*/
public class SysUser implements Serializable {

    /**
    * 用户ID
    */
    
    
    private Long user_id;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 部门ID
    */
    
    private Long dept_id;
    /**
    * 用户账号
    */
    
    
    
    
    private String user_name;
    /**
    * 用户昵称
    */
    
    
    
    
    private String nick_name;
    /**
    * 用户类型（sys_user系统用户）
    */
    
    
    
    private String user_type;
    /**
    * 用户邮箱
    */
    
    
    
    private String email;
    /**
    * 手机号码
    */
    
    
    
    private String phonenumber;
    /**
    * 用户性别（0男 1女 2未知）
    */
    
    private String sex;
    /**
    * 头像地址
    */
    
    private Long avatar;
    /**
    * 密码
    */
    
    
    
    private String password;
    /**
    * 帐号状态（0正常 1停用）
    */
    
    private String status;
    /**
    * 删除标志（0代表存在 2代表删除）
    */
    
    private String del_flag;
    /**
    * 最后登录IP
    */
    
    
    
    private String login_ip;
    /**
    * 最后登录时间
    */
    
    private Date login_date;
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
    * 用户ID
    */
    private void setUser_id(Long user_id){
    this.user_id = user_id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 部门ID
    */
    private void setDept_id(Long dept_id){
    this.dept_id = dept_id;
    }

    /**
    * 用户账号
    */
    private void setUser_name(String user_name){
    this.user_name = user_name;
    }

    /**
    * 用户昵称
    */
    private void setNick_name(String nick_name){
    this.nick_name = nick_name;
    }

    /**
    * 用户类型（sys_user系统用户）
    */
    private void setUser_type(String user_type){
    this.user_type = user_type;
    }

    /**
    * 用户邮箱
    */
    private void setEmail(String email){
    this.email = email;
    }

    /**
    * 手机号码
    */
    private void setPhonenumber(String phonenumber){
    this.phonenumber = phonenumber;
    }

    /**
    * 用户性别（0男 1女 2未知）
    */
    private void setSex(String sex){
    this.sex = sex;
    }

    /**
    * 头像地址
    */
    private void setAvatar(Long avatar){
    this.avatar = avatar;
    }

    /**
    * 密码
    */
    private void setPassword(String password){
    this.password = password;
    }

    /**
    * 帐号状态（0正常 1停用）
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
    * 最后登录IP
    */
    private void setLogin_ip(String login_ip){
    this.login_ip = login_ip;
    }

    /**
    * 最后登录时间
    */
    private void setLogin_date(Date login_date){
    this.login_date = login_date;
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
    * 用户ID
    */
    private Long getUser_id(){
    return this.user_id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 部门ID
    */
    private Long getDept_id(){
    return this.dept_id;
    }

    /**
    * 用户账号
    */
    private String getUser_name(){
    return this.user_name;
    }

    /**
    * 用户昵称
    */
    private String getNick_name(){
    return this.nick_name;
    }

    /**
    * 用户类型（sys_user系统用户）
    */
    private String getUser_type(){
    return this.user_type;
    }

    /**
    * 用户邮箱
    */
    private String getEmail(){
    return this.email;
    }

    /**
    * 手机号码
    */
    private String getPhonenumber(){
    return this.phonenumber;
    }

    /**
    * 用户性别（0男 1女 2未知）
    */
    private String getSex(){
    return this.sex;
    }

    /**
    * 头像地址
    */
    private Long getAvatar(){
    return this.avatar;
    }

    /**
    * 密码
    */
    private String getPassword(){
    return this.password;
    }

    /**
    * 帐号状态（0正常 1停用）
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
    * 最后登录IP
    */
    private String getLogin_ip(){
    return this.login_ip;
    }

    /**
    * 最后登录时间
    */
    private Date getLogin_date(){
    return this.login_date;
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
