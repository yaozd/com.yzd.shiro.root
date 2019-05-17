package com.yzd.shiro.web.api.model.response.role;

import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.web.api.utils.dateExt.DateUtil2;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetListRoleVM {
    private Long id;

    private String roleName;

    private String remark;

    private String gmtCreateTime;

    private String roleCode;

    public static GetListRoleVM toVM(TbRole item) {
        GetListRoleVM getListRoleVM = new GetListRoleVM();
        getListRoleVM.setId(item.getId());
        getListRoleVM.setRoleName(item.getRoleName());
        getListRoleVM.setRemark(item.getRemark());
        getListRoleVM.setRoleCode(item.getRoleCode());
        getListRoleVM.setGmtCreateTime(DateUtil2.getDateStr(item.getGmtCreateTime(),"yyyy-MM-dd HH:mm:ss"));
        return getListRoleVM;
    }
}
