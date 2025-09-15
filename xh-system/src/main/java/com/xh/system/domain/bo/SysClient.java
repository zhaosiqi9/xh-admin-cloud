package com.xh.system.domain.bo;


import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统授权表
 *
 * @TableName sys_client
 */
public class SysClient implements Serializable {

    /**
     * id
     */


    private Long id;
    /**
     * 客户端id
     */


    
    private String client_id;
    /**
     * 客户端key
     */


    
    private String client_key;
    /**
     * 客户端秘钥
     */


    
    private String client_secret;
    /**
     * 授权类型
     */


    
    private String grant_type;
    /**
     * 设备类型
     */


    
    private String device_type;
    /**
     * token活跃超时时间
     */

    private Integer active_timeout;
    /**
     * token固定超时
     */

    private Integer timeout;
    /**
     * 状态（0正常 1停用）
     */

    private String status;
    /**
     * 删除标志（0代表存在 2代表删除）
     */

    private String del_flag;
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
     * id
     */
    private void setId(Long id) {
        this.id = id;
    }

    /**
     * 客户端id
     */
    private void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    /**
     * 客户端key
     */
    private void setClient_key(String client_key) {
        this.client_key = client_key;
    }

    /**
     * 客户端秘钥
     */
    private void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    /**
     * 授权类型
     */
    private void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    /**
     * 设备类型
     */
    private void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    /**
     * token活跃超时时间
     */
    private void setActive_timeout(Integer active_timeout) {
        this.active_timeout = active_timeout;
    }

    /**
     * token固定超时
     */
    private void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    /**
     * 状态（0正常 1停用）
     */
    private void setStatus(String status) {
        this.status = status;
    }

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    /**
     * 创建部门
     */
    private void setCreate_dept(Long create_dept) {
        this.create_dept = create_dept;
    }

    /**
     * 创建者
     */
    private void setCreate_by(Long create_by) {
        this.create_by = create_by;
    }

    /**
     * 创建时间
     */
    private void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    /**
     * 更新者
     */
    private void setUpdate_by(Long update_by) {
        this.update_by = update_by;
    }

    /**
     * 更新时间
     */
    private void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }


    /**
     * id
     */
    private Long getId() {
        return this.id;
    }

    /**
     * 客户端id
     */
    private String getClient_id() {
        return this.client_id;
    }

    /**
     * 客户端key
     */
    private String getClient_key() {
        return this.client_key;
    }

    /**
     * 客户端秘钥
     */
    private String getClient_secret() {
        return this.client_secret;
    }

    /**
     * 授权类型
     */
    private String getGrant_type() {
        return this.grant_type;
    }

    /**
     * 设备类型
     */
    private String getDevice_type() {
        return this.device_type;
    }

    /**
     * token活跃超时时间
     */
    private Integer getActive_timeout() {
        return this.active_timeout;
    }

    /**
     * token固定超时
     */
    private Integer getTimeout() {
        return this.timeout;
    }

    /**
     * 状态（0正常 1停用）
     */
    private String getStatus() {
        return this.status;
    }

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String getDel_flag() {
        return this.del_flag;
    }

    /**
     * 创建部门
     */
    private Long getCreate_dept() {
        return this.create_dept;
    }

    /**
     * 创建者
     */
    private Long getCreate_by() {
        return this.create_by;
    }

    /**
     * 创建时间
     */
    private Date getCreate_time() {
        return this.create_time;
    }

    /**
     * 更新者
     */
    private Long getUpdate_by() {
        return this.update_by;
    }

    /**
     * 更新时间
     */
    private Date getUpdate_time() {
        return this.update_time;
    }

}
