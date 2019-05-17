package com.yzd.shiro.web.api.model.request.role;
import java.util.Date;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.table.TbRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddEditRoleForm {

    private Long id;

    private String roleName;

    private String remark;

    private String roleCode;
    private String permIds;
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
    public static void toEntity4Perm(String permIds){
        String[] arrays=permIds.split(",");
        for (String permid : arrays) {
        }
    }
}
