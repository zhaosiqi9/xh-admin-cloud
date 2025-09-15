package com.xh.system.domain.bo;





import java.io.Serializable;


import org.hibernate.validator.constraints.Length;

/**
* 角色和菜单关联表
* @TableName sys_role_menu
*/
public class SysRoleMenu implements Serializable {

    /**
    * 角色ID
    */
    
    
    private Long role_id;
    /**
    * 菜单ID
    */
    
    
    private Long menu_id;

    /**
    * 角色ID
    */
    private void setRole_id(Long role_id){
    this.role_id = role_id;
    }

    /**
    * 菜单ID
    */
    private void setMenu_id(Long menu_id){
    this.menu_id = menu_id;
    }


    /**
    * 角色ID
    */
    private Long getRole_id(){
    return this.role_id;
    }

    /**
    * 菜单ID
    */
    private Long getMenu_id(){
    return this.menu_id;
    }

}
