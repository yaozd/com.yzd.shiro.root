package com.yzd.shiro.db.entity.table;

import java.util.Date;

public class TbUserRole {
    private Long id;

    private Long userId;

    private Long roleId;

    private String version;

    private Date gmtCreateTime;

    private Integer gmtIsDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Date getGmtCreateTime() {
        return gmtCreateTime;
    }

    public void setGmtCreateTime(Date gmtCreateTime) {
        this.gmtCreateTime = gmtCreateTime;
    }

    public Integer getGmtIsDel() {
        return gmtIsDel;
    }

    public void setGmtIsDel(Integer gmtIsDel) {
        this.gmtIsDel = gmtIsDel;
    }
}