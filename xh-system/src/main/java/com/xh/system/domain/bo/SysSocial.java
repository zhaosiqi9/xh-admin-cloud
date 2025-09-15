package com.xh.system.domain.bo;





import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
* 社会化关系表
* @TableName sys_social
*/
public class SysSocial implements Serializable {

    /**
    * 主键
    */
    
    
    private Long id;
    /**
    * 用户ID
    */
    
    
    private Long user_id;
    /**
    * 租户id
    */
    
    
    
    private String tenant_id;
    /**
    * 平台+平台唯一id
    */
    
    
    
    
    private String auth_id;
    /**
    * 用户来源
    */
    
    
    
    
    private String source;
    /**
    * 平台编号唯一id
    */
    
    
    
    private String open_id;
    /**
    * 登录账号
    */
    
    
    
    
    private String user_name;
    /**
    * 用户昵称
    */
    
    
    
    private String nick_name;
    /**
    * 用户邮箱
    */
    
    
    
    private String email;
    /**
    * 头像地址
    */
    
    
    
    private String avatar;
    /**
    * 用户的授权令牌
    */
    
    
    
    
    private String access_token;
    /**
    * 用户的授权令牌的有效期，部分平台可能没有
    */
    
    private Integer expire_in;
    /**
    * 刷新令牌，部分平台可能没有
    */
    
    
    
    private String refresh_token;
    /**
    * 平台的授权信息，部分平台可能没有
    */
    
    
    
    private String access_code;
    /**
    * 用户的 unionid
    */
    
    
    
    private String union_id;
    /**
    * 授予的权限，部分平台可能没有
    */
    
    
    
    private String scope;
    /**
    * 个别平台的授权信息，部分平台可能没有
    */
    
    
    
    private String token_type;
    /**
    * id token，部分平台可能没有
    */
    
    
    
    private String id_token;
    /**
    * 小米平台用户的附带属性，部分平台可能没有
    */
    
    
    
    private String mac_algorithm;
    /**
    * 小米平台用户的附带属性，部分平台可能没有
    */
    
    
    
    private String mac_key;
    /**
    * 用户的授权code，部分平台可能没有
    */
    
    
    
    private String code;
    /**
    * Twitter平台用户的附带属性，部分平台可能没有
    */
    
    
    
    private String oauth_token;
    /**
    * Twitter平台用户的附带属性，部分平台可能没有
    */
    
    
    
    private String oauth_token_secret;
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
    * 删除标志（0代表存在 2代表删除）
    */
    
    private String del_flag;

    /**
    * 主键
    */
    private void setId(Long id){
    this.id = id;
    }

    /**
    * 用户ID
    */
    private void setUser_id(Long user_id){
    this.user_id = user_id;
    }

    /**
    * 租户id
    */
    private void setTenant_id(String tenant_id){
    this.tenant_id = tenant_id;
    }

    /**
    * 平台+平台唯一id
    */
    private void setAuth_id(String auth_id){
    this.auth_id = auth_id;
    }

    /**
    * 用户来源
    */
    private void setSource(String source){
    this.source = source;
    }

    /**
    * 平台编号唯一id
    */
    private void setOpen_id(String open_id){
    this.open_id = open_id;
    }

    /**
    * 登录账号
    */
    private void setUser_name(String user_name){
    this.user_name = user_name;
    }

    /**
    * 用户昵称
    */
    private void setNick_name(String nick_name){
    this.nick_name = nick_name;
    }

    /**
    * 用户邮箱
    */
    private void setEmail(String email){
    this.email = email;
    }

    /**
    * 头像地址
    */
    private void setAvatar(String avatar){
    this.avatar = avatar;
    }

    /**
    * 用户的授权令牌
    */
    private void setAccess_token(String access_token){
    this.access_token = access_token;
    }

    /**
    * 用户的授权令牌的有效期，部分平台可能没有
    */
    private void setExpire_in(Integer expire_in){
    this.expire_in = expire_in;
    }

    /**
    * 刷新令牌，部分平台可能没有
    */
    private void setRefresh_token(String refresh_token){
    this.refresh_token = refresh_token;
    }

    /**
    * 平台的授权信息，部分平台可能没有
    */
    private void setAccess_code(String access_code){
    this.access_code = access_code;
    }

    /**
    * 用户的 unionid
    */
    private void setUnion_id(String union_id){
    this.union_id = union_id;
    }

    /**
    * 授予的权限，部分平台可能没有
    */
    private void setScope(String scope){
    this.scope = scope;
    }

    /**
    * 个别平台的授权信息，部分平台可能没有
    */
    private void setToken_type(String token_type){
    this.token_type = token_type;
    }

    /**
    * id token，部分平台可能没有
    */
    private void setId_token(String id_token){
    this.id_token = id_token;
    }

    /**
    * 小米平台用户的附带属性，部分平台可能没有
    */
    private void setMac_algorithm(String mac_algorithm){
    this.mac_algorithm = mac_algorithm;
    }

    /**
    * 小米平台用户的附带属性，部分平台可能没有
    */
    private void setMac_key(String mac_key){
    this.mac_key = mac_key;
    }

    /**
    * 用户的授权code，部分平台可能没有
    */
    private void setCode(String code){
    this.code = code;
    }

    /**
    * Twitter平台用户的附带属性，部分平台可能没有
    */
    private void setOauth_token(String oauth_token){
    this.oauth_token = oauth_token;
    }

    /**
    * Twitter平台用户的附带属性，部分平台可能没有
    */
    private void setOauth_token_secret(String oauth_token_secret){
    this.oauth_token_secret = oauth_token_secret;
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
    * 删除标志（0代表存在 2代表删除）
    */
    private void setDel_flag(String del_flag){
    this.del_flag = del_flag;
    }


    /**
    * 主键
    */
    private Long getId(){
    return this.id;
    }

    /**
    * 用户ID
    */
    private Long getUser_id(){
    return this.user_id;
    }

    /**
    * 租户id
    */
    private String getTenant_id(){
    return this.tenant_id;
    }

    /**
    * 平台+平台唯一id
    */
    private String getAuth_id(){
    return this.auth_id;
    }

    /**
    * 用户来源
    */
    private String getSource(){
    return this.source;
    }

    /**
    * 平台编号唯一id
    */
    private String getOpen_id(){
    return this.open_id;
    }

    /**
    * 登录账号
    */
    private String getUser_name(){
    return this.user_name;
    }

    /**
    * 用户昵称
    */
    private String getNick_name(){
    return this.nick_name;
    }

    /**
    * 用户邮箱
    */
    private String getEmail(){
    return this.email;
    }

    /**
    * 头像地址
    */
    private String getAvatar(){
    return this.avatar;
    }

    /**
    * 用户的授权令牌
    */
    private String getAccess_token(){
    return this.access_token;
    }

    /**
    * 用户的授权令牌的有效期，部分平台可能没有
    */
    private Integer getExpire_in(){
    return this.expire_in;
    }

    /**
    * 刷新令牌，部分平台可能没有
    */
    private String getRefresh_token(){
    return this.refresh_token;
    }

    /**
    * 平台的授权信息，部分平台可能没有
    */
    private String getAccess_code(){
    return this.access_code;
    }

    /**
    * 用户的 unionid
    */
    private String getUnion_id(){
    return this.union_id;
    }

    /**
    * 授予的权限，部分平台可能没有
    */
    private String getScope(){
    return this.scope;
    }

    /**
    * 个别平台的授权信息，部分平台可能没有
    */
    private String getToken_type(){
    return this.token_type;
    }

    /**
    * id token，部分平台可能没有
    */
    private String getId_token(){
    return this.id_token;
    }

    /**
    * 小米平台用户的附带属性，部分平台可能没有
    */
    private String getMac_algorithm(){
    return this.mac_algorithm;
    }

    /**
    * 小米平台用户的附带属性，部分平台可能没有
    */
    private String getMac_key(){
    return this.mac_key;
    }

    /**
    * 用户的授权code，部分平台可能没有
    */
    private String getCode(){
    return this.code;
    }

    /**
    * Twitter平台用户的附带属性，部分平台可能没有
    */
    private String getOauth_token(){
    return this.oauth_token;
    }

    /**
    * Twitter平台用户的附带属性，部分平台可能没有
    */
    private String getOauth_token_secret(){
    return this.oauth_token_secret;
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
    * 删除标志（0代表存在 2代表删除）
    */
    private String getDel_flag(){
    return this.del_flag;
    }

}
