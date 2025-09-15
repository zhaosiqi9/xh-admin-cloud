package com.xh.system.domain.bo;





import java.io.Serializable;


import org.hibernate.validator.constraints.Length;

/**
* 用户与岗位关联表
* @TableName sys_user_post
*/
public class SysUserPost implements Serializable {

    /**
    * 用户ID
    */
    
    
    private Long user_id;
    /**
    * 岗位ID
    */
    
    
    private Long post_id;

    /**
    * 用户ID
    */
    private void setUser_id(Long user_id){
    this.user_id = user_id;
    }

    /**
    * 岗位ID
    */
    private void setPost_id(Long post_id){
    this.post_id = post_id;
    }


    /**
    * 用户ID
    */
    private Long getUser_id(){
    return this.user_id;
    }

    /**
    * 岗位ID
    */
    private Long getPost_id(){
    return this.post_id;
    }

}
