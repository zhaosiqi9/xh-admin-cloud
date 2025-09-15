package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 参数配置表
* @TableName sys_config
*/
public class SysConfig implements Serializable {

    /**
    * 参数主键
    */
    
    
    private Long config_id;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 参数名称
    */
    
    
    
    private String config_name;
    /**
    * 参数键名
    */
    
    
    
    private String config_key;
    /**
    * 参数键值
    */
    
    
    
    private String config_value;
    /**
    * 系统内置（Y是 N否）
    */
    
    private String config_type;
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
    * 参数主键
    */
    private void setConfig_id(Long config_id){
    this.config_id = config_id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 参数名称
    */
    private void setConfig_name(String config_name){
    this.config_name = config_name;
    }

    /**
    * 参数键名
    */
    private void setConfig_key(String config_key){
    this.config_key = config_key;
    }

    /**
    * 参数键值
    */
    private void setConfig_value(String config_value){
    this.config_value = config_value;
    }

    /**
    * 系统内置（Y是 N否）
    */
    private void setConfig_type(String config_type){
    this.config_type = config_type;
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
    * 参数主键
    */
    private Long getConfig_id(){
    return this.config_id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 参数名称
    */
    private String getConfig_name(){
    return this.config_name;
    }

    /**
    * 参数键名
    */
    private String getConfig_key(){
    return this.config_key;
    }

    /**
    * 参数键值
    */
    private String getConfig_value(){
    return this.config_value;
    }

    /**
    * 系统内置（Y是 N否）
    */
    private String getConfig_type(){
    return this.config_type;
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
