package com.yzd.shiro.web.api.model.response.auth;

import com.yzd.shiro.db.entity.table.TbPermission;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetListPermVM {
    private Long id;

    private String name;

    private String permissionCode;

    private Integer sortNo;

    private Integer visibleStatus;

    private Integer enableStatus;

    private Integer permissionType;

    private String url;
    public static GetListPermVM toVM(TbPermission item) {
        GetListPermVM getListPermVM = new GetListPermVM();
        getListPermVM.setId(item.getId());
        getListPermVM.setName(item.getName());
        getListPermVM.setPermissionCode(item.getPermissionCode());
        getListPermVM.setSortNo(item.getSortNo());
        getListPermVM.setVisibleStatus(item.getVisibleStatus());
        getListPermVM.setEnableStatus(item.getEnableStatus());
        getListPermVM.setPermissionType(item.getPermissionType());
        getListPermVM.setUrl(item.getUrl());
        return getListPermVM;
    }
}
