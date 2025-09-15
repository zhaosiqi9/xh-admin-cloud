package com.xh.system.domain.bo;


import java.io.Serializable;

import java.util.Date;

import org.hibernate.validator.constraints.Length;

/**
 * 通知公告表
 *
 * @TableName sys_notice
 */
public class SysNotice implements Serializable {

    /**
     * 公告ID
     */


    private Long notice_id;
    /**
     * 租户编号
     */


    
    private String tenant_id;
    /**
     * 公告标题
     */
    

    
    private String notice_title;
    /**
     * 公告类型（1通知 2公告）
     */


    private String notice_type;
    /**
     * 公告状态（0正常 1关闭）
     */

    private String status;
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
     * 公告内容
     */

    private byte[] notice_content;

    /**
     * 公告ID
     */
    private void setNotice_id(Long notice_id) {
        this.notice_id = notice_id;
    }

    /**
     * 租户编号
     */
    private void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    /**
     * 公告标题
     */
    private void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    /**
     * 公告类型（1通知 2公告）
     */
    private void setNotice_type(String notice_type) {
        this.notice_type = notice_type;
    }

    /**
     * 公告状态（0正常 1关闭）
     */
    private void setStatus(String status) {
        this.status = status;
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
     * 备注
     */
    private void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 公告内容
     */
    private void setNotice_content(byte[] notice_content) {
        this.notice_content = notice_content;
    }


    /**
     * 公告ID
     */
    private Long getNotice_id() {
        return this.notice_id;
    }

    /**
     * 租户编号
     */
    private String getTenant_id() {
        return this.tenant_id;
    }

    /**
     * 公告标题
     */
    private String getNotice_title() {
        return this.notice_title;
    }

    /**
     * 公告类型（1通知 2公告）
     */
    private String getNotice_type() {
        return this.notice_type;
    }

    /**
     * 公告状态（0正常 1关闭）
     */
    private String getStatus() {
        return this.status;
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

    /**
     * 备注
     */
    private String getRemark() {
        return this.remark;
    }

    /**
     * 公告内容
     */
    private byte[] getNotice_content() {
        return this.notice_content;
    }

}
