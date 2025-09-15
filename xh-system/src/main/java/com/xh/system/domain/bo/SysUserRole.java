package com.xh.system.domain.bo;





import java.io.Serializable;


import org.hibernate.validator.constraints.Length;

/**
* 用户和角色关联表
* @TableName sys_user_role
*/
public class SysUserRole implements Serializable {

    /**
    * 用户ID
    */
    
    
    private Long user_id;
    /**
    * 角色ID
    */
    
    
    private Long role_id;

    /**
    * 用户ID
    */
    private void setUser_id(Long user_id){
    this.user_id = user_id;
    }

    /**
    * 角色ID
    */
    private void setRole_id(Long role_id){
    this.role_id = role_id;
    }


    /**
    * 用户ID
    */
    private Long getUser_id(){
    return this.user_id;
    }

    /**
    * 角色ID
    */
    private Long getRole_id(){
    return this.role_id;
    }

}
