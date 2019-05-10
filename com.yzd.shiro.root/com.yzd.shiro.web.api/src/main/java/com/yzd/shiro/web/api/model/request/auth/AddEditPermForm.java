package com.yzd.shiro.web.api.model.request.auth;

import com.yzd.shiro.db.entity.enumExt.TbPermissionEnum;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.web.api.utils.enumExt.EnumUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddEditPermForm {
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

    public static TbPermission toEntity(AddEditPermForm form) {
        TbPermission tbPermission = new TbPermission();
        tbPermission.setId(form.getId());
        tbPermission.setName(form.getName());
        tbPermission.setPermissionCode(form.getPermissionCode());
        tbPermission.setSortNo(form.getSortNo());
        tbPermission.setVisibleStatus(EnumUtil.checkCode("可见状态",TbPermissionEnum.visibleStatus.CODES,form.getVisibleStatus()));
        tbPermission.setEnableStatus(EnumUtil.checkCode("启用状态",TbPermissionEnum.enableStatus.CODES,form.getEnableStatus()));
        tbPermission.setPermissionType(EnumUtil.checkCode("资源类型",TbPermissionEnum.permissionType.CODES,form.getPermissionType()));
        tbPermission.setUrl(form.getUrl());
        tbPermission.setParentId(form.getParentId());
        tbPermission.setRemark(form.getRemark());
        return tbPermission;
    }
}
