package com.yzd.shiro.db.entity.table;

import java.util.Date;

public class TbRolePermission {
    private Long id;

    private Long permissionId;

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

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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