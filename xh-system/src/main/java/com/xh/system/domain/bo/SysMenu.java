package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 菜单权限表
* @TableName sys_menu
*/
public class SysMenu implements Serializable {

    /**
    * 菜单ID
    */
    
    
    private Long menu_id;
    /**
    * 菜单名称
    */
    
    
    
    
    private String menu_name;
    /**
    * 父菜单ID
    */
    
    private Long parent_id;
    /**
    * 显示顺序
    */
    
    private Integer order_num;
    /**
    * 路由地址
    */
    
    
    
    private String path;
    /**
    * 组件路径
    */
    
    
    
    private String component;
    /**
    * 路由参数
    */
    
    
    
    private String query_param;
    /**
    * 是否为外链（0是 1否）
    */
    
    private Integer is_frame;
    /**
    * 是否缓存（0缓存 1不缓存）
    */
    
    private Integer is_cache;
    /**
    * 菜单类型（M目录 C菜单 F按钮）
    */
    
    private String menu_type;
    /**
    * 显示状态（0显示 1隐藏）
    */
    
    private String visible;
    /**
    * 菜单状态（0正常 1停用）
    */
    
    private String status;
    /**
    * 权限标识
    */
    
    
    
    private String perms;
    /**
    * 菜单图标
    */
    
    
    
    private String icon;
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
    * 菜单ID
    */
    private void setMenu_id(Long menu_id){
    this.menu_id = menu_id;
    }

    /**
    * 菜单名称
    */
    private void setMenu_name(String menu_name){
    this.menu_name = menu_name;
    }

    /**
    * 父菜单ID
    */
    private void setParent_id(Long parent_id){
    this.parent_id = parent_id;
    }

    /**
    * 显示顺序
    */
    private void setOrder_num(Integer order_num){
    this.order_num = order_num;
    }

    /**
    * 路由地址
    */
    private void setPath(String path){
    this.path = path;
    }

    /**
    * 组件路径
    */
    private void setComponent(String component){
    this.component = component;
    }

    /**
    * 路由参数
    */
    private void setQuery_param(String query_param){
    this.query_param = query_param;
    }

    /**
    * 是否为外链（0是 1否）
    */
    private void setIs_frame(Integer is_frame){
    this.is_frame = is_frame;
    }

    /**
    * 是否缓存（0缓存 1不缓存）
    */
    private void setIs_cache(Integer is_cache){
    this.is_cache = is_cache;
    }

    /**
    * 菜单类型（M目录 C菜单 F按钮）
    */
    private void setMenu_type(String menu_type){
    this.menu_type = menu_type;
    }

    /**
    * 显示状态（0显示 1隐藏）
    */
    private void setVisible(String visible){
    this.visible = visible;
    }

    /**
    * 菜单状态（0正常 1停用）
    */
    private void setStatus(String status){
    this.status = status;
    }

    /**
    * 权限标识
    */
    private void setPerms(String perms){
    this.perms = perms;
    }

    /**
    * 菜单图标
    */
    private void setIcon(String icon){
    this.icon = icon;
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
    * 菜单ID
    */
    private Long getMenu_id(){
    return this.menu_id;
    }

    /**
    * 菜单名称
    */
    private String getMenu_name(){
    return this.menu_name;
    }

    /**
    * 父菜单ID
    */
    private Long getParent_id(){
    return this.parent_id;
    }

    /**
    * 显示顺序
    */
    private Integer getOrder_num(){
    return this.order_num;
    }

    /**
    * 路由地址
    */
    private String getPath(){
    return this.path;
    }

    /**
    * 组件路径
    */
    private String getComponent(){
    return this.component;
    }

    /**
    * 路由参数
    */
    private String getQuery_param(){
    return this.query_param;
    }

    /**
    * 是否为外链（0是 1否）
    */
    private Integer getIs_frame(){
    return this.is_frame;
    }

    /**
    * 是否缓存（0缓存 1不缓存）
    */
    private Integer getIs_cache(){
    return this.is_cache;
    }

    /**
    * 菜单类型（M目录 C菜单 F按钮）
    */
    private String getMenu_type(){
    return this.menu_type;
    }

    /**
    * 显示状态（0显示 1隐藏）
    */
    private String getVisible(){
    return this.visible;
    }

    /**
    * 菜单状态（0正常 1停用）
    */
    private String getStatus(){
    return this.status;
    }

    /**
    * 权限标识
    */
    private String getPerms(){
    return this.perms;
    }

    /**
    * 菜单图标
    */
    private String getIcon(){
    return this.icon;
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
