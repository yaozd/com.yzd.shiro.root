package com.yzd.shiro.db.entity.table;

import java.util.Date;

public class TbRole {
    private Long id;

    private String roleName;

    private String remark;

    private String roleCode;

    private Date gmtCreateTime;

    private Date gmtUpdateTime;

    private Integer gmtIsDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Date getGmtUpdateTime() {
        return gmtUpdateTime;
    }

    public void setGmtUpdateTime(Date gmtUpdateTime) {
        this.gmtUpdateTime = gmtUpdateTime;
    }

    public Integer getGmtIsDel() {
        return gmtIsDel;
    }

    public void setGmtIsDel(Integer gmtIsDel) {
        this.gmtIsDel = gmtIsDel;
    }
}