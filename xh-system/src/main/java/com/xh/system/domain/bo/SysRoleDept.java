package com.xh.system.domain.bo;





import java.io.Serializable;


import org.hibernate.validator.constraints.Length;

/**
* 角色和部门关联表
* @TableName sys_role_dept
*/
public class SysRoleDept implements Serializable {

    /**
    * 角色ID
    */
    
    
    private Long role_id;
    /**
    * 部门ID
    */
    
    
    private Long dept_id;

    /**
    * 角色ID
    */
    private void setRole_id(Long role_id){
    this.role_id = role_id;
    }

    /**
    * 部门ID
    */
    private void setDept_id(Long dept_id){
    this.dept_id = dept_id;
    }


    /**
    * 角色ID
    */
    private Long getRole_id(){
    return this.role_id;
    }

    /**
    * 部门ID
    */
    private Long getDept_id(){
    return this.dept_id;
    }

}
