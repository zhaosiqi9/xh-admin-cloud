package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 字典类型表
* @TableName sys_dict_type
*/
public class SysDictType implements Serializable {

    /**
    * 字典主键
    */
    
    
    private Long dict_id;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 字典名称
    */
    
    
    
    private String dict_name;
    /**
    * 字典类型
    */
    
    
    
    private String dict_type;
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
    * 字典主键
    */
    private void setDict_id(Long dict_id){
    this.dict_id = dict_id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 字典名称
    */
    private void setDict_name(String dict_name){
    this.dict_name = dict_name;
    }

    /**
    * 字典类型
    */
    private void setDict_type(String dict_type){
    this.dict_type = dict_type;
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
    * 字典主键
    */
    private Long getDict_id(){
    return this.dict_id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 字典名称
    */
    private String getDict_name(){
    return this.dict_name;
    }

    /**
    * 字典类型
    */
    private String getDict_type(){
    return this.dict_type;
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
