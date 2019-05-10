package com.yzd.shiro.db.entity.table;

public class TbPermission {
    private Long id;

    private String name;

    private String permissionCode;

    private Integer sortNo;

    private Integer visibleStatus;

    private Integer enableStatus;

    private Integer permissionType;

    private String url;

    private Long parentId;

    private String remark;

    private Integer gmtIsDel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public Integer getVisibleStatus() {
        return visibleStatus;
    }

    public void setVisibleStatus(Integer visibleStatus) {
        this.visibleStatus = visibleStatus;
    }

    public Integer getEnableStatus() {
        return enableStatus;
    }

    public void setEnableStatus(Integer enableStatus) {
        this.enableStatus = enableStatus;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getGmtIsDel() {
        return gmtIsDel;
    }

    public void setGmtIsDel(Integer gmtIsDel) {
        this.gmtIsDel = gmtIsDel;
    }
}