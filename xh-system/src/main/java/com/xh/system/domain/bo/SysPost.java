package com.xh.system.domain.bo;


import java.io.Serializable;
import java.util.Date;

/**
 * 岗位信息表
 *
 * @TableName sys_post
 */
public class SysPost implements Serializable {

    /**
     * 岗位ID
     */


    private Long post_id;
    /**
     * 租户编号
     */


    private String tenant_id;
    /**
     * 部门id
     */


    private Long dept_id;
    /**
     * 岗位编码
     */


    private String post_code;
    /**
     * 岗位类别编码
     */


    private String post_category;
    /**
     * 岗位名称
     */


    private String post_name;
    /**
     * 显示顺序
     */


    private Integer post_sort;
    /**
     * 状态（0正常 1停用）
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
     * 岗位ID
     */
    private Long getPost_id() {
        return this.post_id;
    }

    /**
     * 岗位ID
     */
    private void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    /**
     * 租户编号
     */
    private String getTenant_id() {
        return this.tenant_id;
    }

    /**
     * 租户编号
     */
    private void setTenant_id(String tenant_id) {
        this.tenant_id = tenant_id;
    }

    /**
     * 部门id
     */
    private Long getDept_id() {
        return this.dept_id;
    }

    /**
     * 部门id
     */
    private void setDept_id(Long dept_id) {
        this.dept_id = dept_id;
    }

    /**
     * 岗位编码
     */
    private String getPost_code() {
        return this.post_code;
    }

    /**
     * 岗位编码
     */
    private void setPost_code(String post_code) {
        this.post_code = post_code;
    }

    /**
     * 岗位类别编码
     */
    private String getPost_category() {
        return this.post_category;
    }

    /**
     * 岗位类别编码
     */
    private void setPost_category(String post_category) {
        this.post_category = post_category;
    }

    /**
     * 岗位名称
     */
    private String getPost_name() {
        return this.post_name;
    }

    /**
     * 岗位名称
     */
    private void setPost_name(String post_name) {
        this.post_name = post_name;
    }

    /**
     * 显示顺序
     */
    private Integer getPost_sort() {
        return this.post_sort;
    }

    /**
     * 显示顺序
     */
    private void setPost_sort(Integer post_sort) {
        this.post_sort = post_sort;
    }

    /**
     * 状态（0正常 1停用）
     */
    private String getStatus() {
        return this.status;
    }

    /**
     * 状态（0正常 1停用）
     */
    private void setStatus(String status) {
        this.status = status;
    }

    /**
     * 创建部门
     */
    private Long getCreate_dept() {
        return this.create_dept;
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
    private Long getCreate_by() {
        return this.create_by;
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
    private Date getCreate_time() {
        return this.create_time;
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
    private Long getUpdate_by() {
        return this.update_by;
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
    private Date getUpdate_time() {
        return this.update_time;
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
    private String getRemark() {
        return this.remark;
    }

    /**
     * 备注
     */
    private void setRemark(String remark) {
        this.remark = remark;
    }

}
