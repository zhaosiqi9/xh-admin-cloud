package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 操作日志记录
* @TableName sys_oper_log
*/
public class SysOperLog implements Serializable {

    /**
    * 日志主键
    */
    
    
    private Long oper_id;
    /**
    * 租户编号
    */
    
    
    
    private String tenant_id;
    /**
    * 模块标题
    */
    
    
    
    private String title;
    /**
    * 业务类型（0其它 1新增 2修改 3删除）
    */
    
    private Integer business_type;
    /**
    * 方法名称
    */
    
    
    
    private String method;
    /**
    * 请求方式
    */
    
    
    
    private String request_method;
    /**
    * 操作类别（0其它 1后台用户 2手机端用户）
    */
    
    private Integer operator_type;
    /**
    * 操作人员
    */
    
    
    
    private String oper_name;
    /**
    * 部门名称
    */
    
    
    
    private String dept_name;
    /**
    * 请求URL
    */
    
    
    
    private String oper_url;
    /**
    * 主机地址
    */
    
    
    
    private String oper_ip;
    /**
    * 操作地点
    */
    
    
    
    private String oper_location;
    /**
    * 请求参数
    */
    
    
    
    private String oper_param;
    /**
    * 返回参数
    */
    
    
    
    private String json_result;
    /**
    * 操作状态（0正常 1异常）
    */
    
    private Integer status;
    /**
    * 错误消息
    */
    
    
    
    private String error_msg;
    /**
    * 操作时间
    */
    
    private Date oper_time;
    /**
    * 消耗时间
    */
    
    private Long cost_time;

    /**
    * 日志主键
    */
    private void setOper_id(Long oper_id){
    this.oper_id = oper_id;
    }

    /**
    * 租户编号
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 模块标题
    */
    private void setTitle(String title){
    this.title = title;
    }

    /**
    * 业务类型（0其它 1新增 2修改 3删除）
    */
    private void setBusiness_type(Integer business_type){
    this.business_type = business_type;
    }

    /**
    * 方法名称
    */
    private void setMethod(String method){
    this.method = method;
    }

    /**
    * 请求方式
    */
    private void setRequest_method(String request_method){
    this.request_method = request_method;
    }

    /**
    * 操作类别（0其它 1后台用户 2手机端用户）
    */
    private void setOperator_type(Integer operator_type){
    this.operator_type = operator_type;
    }

    /**
    * 操作人员
    */
    private void setOper_name(String oper_name){
    this.oper_name = oper_name;
    }

    /**
    * 部门名称
    */
    private void setDept_name(String dept_name){
    this.dept_name = dept_name;
    }

    /**
    * 请求URL
    */
    private void setOper_url(String oper_url){
    this.oper_url = oper_url;
    }

    /**
    * 主机地址
    */
    private void setOper_ip(String oper_ip){
    this.oper_ip = oper_ip;
    }

    /**
    * 操作地点
    */
    private void setOper_location(String oper_location){
    this.oper_location = oper_location;
    }

    /**
    * 请求参数
    */
    private void setOper_param(String oper_param){
    this.oper_param = oper_param;
    }

    /**
    * 返回参数
    */
    private void setJson_result(String json_result){
    this.json_result = json_result;
    }

    /**
    * 操作状态（0正常 1异常）
    */
    private void setStatus(Integer status){
    this.status = status;
    }

    /**
    * 错误消息
    */
    private void setError_msg(String error_msg){
    this.error_msg = error_msg;
    }

    /**
    * 操作时间
    */
    private void setOper_time(Date oper_time){
    this.oper_time = oper_time;
    }

    /**
    * 消耗时间
    */
    private void setCost_time(Long cost_time){
    this.cost_time = cost_time;
    }


    /**
    * 日志主键
    */
    private Long getOper_id(){
    return this.oper_id;
    }

    /**
    * 租户编号
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 模块标题
    */
    private String getTitle(){
    return this.title;
    }

    /**
    * 业务类型（0其它 1新增 2修改 3删除）
    */
    private Integer getBusiness_type(){
    return this.business_type;
    }

    /**
    * 方法名称
    */
    private String getMethod(){
    return this.method;
    }

    /**
    * 请求方式
    */
    private String getRequest_method(){
    return this.request_method;
    }

    /**
    * 操作类别（0其它 1后台用户 2手机端用户）
    */
    private Integer getOperator_type(){
    return this.operator_type;
    }

    /**
    * 操作人员
    */
    private String getOper_name(){
    return this.oper_name;
    }

    /**
    * 部门名称
    */
    private String getDept_name(){
    return this.dept_name;
    }

    /**
    * 请求URL
    */
    private String getOper_url(){
    return this.oper_url;
    }

    /**
    * 主机地址
    */
    private String getOper_ip(){
    return this.oper_ip;
    }

    /**
    * 操作地点
    */
    private String getOper_location(){
    return this.oper_location;
    }

    /**
    * 请求参数
    */
    private String getOper_param(){
    return this.oper_param;
    }

    /**
    * 返回参数
    */
    private String getJson_result(){
    return this.json_result;
    }

    /**
    * 操作状态（0正常 1异常）
    */
    private Integer getStatus(){
    return this.status;
    }

    /**
    * 错误消息
    */
    private String getError_msg(){
    return this.error_msg;
    }

    /**
    * 操作时间
    */
    private Date getOper_time(){
    return this.oper_time;
    }

    /**
    * 消耗时间
    */
    private Long getCost_time(){
    return this.cost_time;
    }

}
