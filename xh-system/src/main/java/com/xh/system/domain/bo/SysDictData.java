package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 字典数据表
* @TableName sys_dict_data
*/
public class SysDictData implements Serializable {

    /**
    * 字典编码
    */
    
    
    private Long dict_code;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 字典排序
    */
    
    private Integer dict_sort;
    /**
    * 字典标签
    */
    
    
    
    private String dict_label;
    /**
    * 字典键值
    */
    
    
    
    private String dict_value;
    /**
    * 字典类型
    */
    
    
    
    private String dict_type;
    /**
    * 样式属性（其他样式扩展）
    */
    
    
    
    private String css_class;
    /**
    * 表格回显样式
    */
    
    
    
    private String list_class;
    /**
    * 是否默认（Y是 N否）
    */
    
    private String is_default;
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
    * 字典编码
    */
    private void setDict_code(Long dict_code){
    this.dict_code = dict_code;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 字典排序
    */
    private void setDict_sort(Integer dict_sort){
    this.dict_sort = dict_sort;
    }

    /**
    * 字典标签
    */
    private void setDict_label(String dict_label){
    this.dict_label = dict_label;
    }

    /**
    * 字典键值
    */
    private void setDict_value(String dict_value){
    this.dict_value = dict_value;
    }

    /**
    * 字典类型
    */
    private void setDict_type(String dict_type){
    this.dict_type = dict_type;
    }

    /**
    * 样式属性（其他样式扩展）
    */
    private void setCss_class(String css_class){
    this.css_class = css_class;
    }

    /**
    * 表格回显样式
    */
    private void setList_class(String list_class){
    this.list_class = list_class;
    }

    /**
    * 是否默认（Y是 N否）
    */
    private void setIs_default(String is_default){
    this.is_default = is_default;
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
    * 字典编码
    */
    private Long getDict_code(){
    return this.dict_code;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 字典排序
    */
    private Integer getDict_sort(){
    return this.dict_sort;
    }

    /**
    * 字典标签
    */
    private String getDict_label(){
    return this.dict_label;
    }

    /**
    * 字典键值
    */
    private String getDict_value(){
    return this.dict_value;
    }

    /**
    * 字典类型
    */
    private String getDict_type(){
    return this.dict_type;
    }

    /**
    * 样式属性（其他样式扩展）
    */
    private String getCss_class(){
    return this.css_class;
    }

    /**
    * 表格回显样式
    */
    private String getList_class(){
    return this.list_class;
    }

    /**
    * 是否默认（Y是 N否）
    */
    private String getIs_default(){
    return this.is_default;
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
