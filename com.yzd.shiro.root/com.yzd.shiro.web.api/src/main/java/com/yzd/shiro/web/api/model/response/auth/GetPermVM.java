package com.yzd.shiro.web.api.model.response.auth;

import com.yzd.shiro.db.entity.table.TbPermission;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetPermVM {
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
    public static GetPermVM toVM(TbPermission item) {
        GetPermVM getPermVM = new GetPermVM();
        getPermVM.setId(item.getId());
        getPermVM.setName(item.getName());
        getPermVM.setPermissionCode(item.getPermissionCode());
        getPermVM.setSortNo(item.getSortNo());
        getPermVM.setVisibleStatus(item.getVisibleStatus());
        getPermVM.setEnableStatus(item.getEnableStatus());
        getPermVM.setPermissionType(item.getPermissionType());
        getPermVM.setUrl(item.getUrl());
        getPermVM.setParentId(item.getParentId());
        getPermVM.setRemark(item.getRemark());
        return getPermVM;
    }
}
