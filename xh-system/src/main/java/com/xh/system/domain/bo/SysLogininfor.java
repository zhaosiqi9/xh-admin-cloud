package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 系统访问记录
* @TableName sys_logininfor
*/
public class SysLogininfor implements Serializable {

    /**
    * 访问ID
    */
    
    
    private Long info_id;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 用户账号
    */
    
    
    
    private String user_name;
    /**
    * 客户端
    */
    
    
    
    private String client_key;
    /**
    * 设备类型
    */
    
    
    
    private String device_type;
    /**
    * 登录IP地址
    */
    
    
    
    private String ipaddr;
    /**
    * 登录地点
    */
    
    
    
    private String login_location;
    /**
    * 浏览器类型
    */
    
    
    
    private String browser;
    /**
    * 操作系统
    */
    
    
    
    private String os;
    /**
    * 登录状态（0成功 1失败）
    */
    
    private String status;
    /**
    * 提示消息
    */
    
    
    
    private String msg;
    /**
    * 访问时间
    */
    
    private Date login_time;

    /**
    * 访问ID
    */
    private void setInfo_id(Long info_id){
    this.info_id = info_id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 用户账号
    */
    private void setUser_name(String user_name){
    this.user_name = user_name;
    }

    /**
    * 客户端
    */
    private void setClient_key(String client_key){
    this.client_key = client_key;
    }

    /**
    * 设备类型
    */
    private void setDevice_type(String device_type){
    this.device_type = device_type;
    }

    /**
    * 登录IP地址
    */
    private void setIpaddr(String ipaddr){
    this.ipaddr = ipaddr;
    }

    /**
    * 登录地点
    */
    private void setLogin_location(String login_location){
    this.login_location = login_location;
    }

    /**
    * 浏览器类型
    */
    private void setBrowser(String browser){
    this.browser = browser;
    }

    /**
    * 操作系统
    */
    private void setOs(String os){
    this.os = os;
    }

    /**
    * 登录状态（0成功 1失败）
    */
    private void setStatus(String status){
    this.status = status;
    }

    /**
    * 提示消息
    */
    private void setMsg(String msg){
    this.msg = msg;
    }

    /**
    * 访问时间
    */
    private void setLogin_time(Date login_time){
    this.login_time = login_time;
    }


    /**
    * 访问ID
    */
    private Long getInfo_id(){
    return this.info_id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 用户账号
    */
    private String getUser_name(){
    return this.user_name;
    }

    /**
    * 客户端
    */
    private String getClient_key(){
    return this.client_key;
    }

    /**
    * 设备类型
    */
    private String getDevice_type(){
    return this.device_type;
    }

    /**
    * 登录IP地址
    */
    private String getIpaddr(){
    return this.ipaddr;
    }

    /**
    * 登录地点
    */
    private String getLogin_location(){
    return this.login_location;
    }

    /**
    * 浏览器类型
    */
    private String getBrowser(){
    return this.browser;
    }

    /**
    * 操作系统
    */
    private String getOs(){
    return this.os;
    }

    /**
    * 登录状态（0成功 1失败）
    */
    private String getStatus(){
    return this.status;
    }

    /**
    * 提示消息
    */
    private String getMsg(){
    return this.msg;
    }

    /**
    * 访问时间
    */
    private Date getLogin_time(){
    return this.login_time;
    }

}
