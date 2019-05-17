package com.yzd.shiro.web.api.model.request.role;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import com.yzd.shiro.web.api.utils.dateExt.DateUtil2;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class AddEditRoleForm {

    private Long id;

    private String roleName;

    private String remark;

    private String roleCode;

    private List<Long> permIds = new ArrayList<>();

    public static TbRole toEntity(AddEditRoleForm form) {
        TbRole tbRole = new TbRole();
        tbRole.setId(form.getId());
        tbRole.setRoleName(form.getRoleName());
        tbRole.setRemark(form.getRemark());
        tbRole.setRoleCode(form.getRoleCode());
        tbRole.setGmtCreateTime(new Date());
        tbRole.setGmtUpdateTime(new Date());
        tbRole.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return tbRole;
    }

    public static List<TbRolePermission> toEntity4RolePermission(Long roleId, List<Long> permIds) {
        List<TbRolePermission> itemList4RolePermission = new ArrayList<>();
        String version = DateUtil2.getDateStr(new Date(), "yyyyMMddHHmmss");
        for (Long permId : permIds) {
            TbRolePermission item = new TbRolePermission();
            item.setPermissionId(permId);
            item.setRoleId(roleId);
            item.setVersion(version);
            item.setGmtCreateTime(new Date());
            item.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
            itemList4RolePermission.add(item);
        }
        return itemList4RolePermission;
    }
    public static TbRolePermission toEntity4RolePermissionUpdate(Long roleId){
        TbRolePermission item4RolePermissionUpdate=new TbRolePermission();
        item4RolePermissionUpdate.setRoleId(roleId);
        item4RolePermissionUpdate.setGmtIsDel(TbPublicEnum.gmtIsDel.YES.CODE);
        return item4RolePermissionUpdate;
    }
}
