package com.yzd.shiro.web.api.model.response.role;
import com.google.common.collect.Lists;

import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.table.TbRolePermission;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class GetRoleVM {
    private Long id;

    private String roleName;

    private String remark;

    private String roleCode;

    private List<Long> permIds = new ArrayList<>();

    public static GetRoleVM toVM(TbRole item4Role, List<TbRolePermission> rolePermissionList) {
        GetRoleVM getRoleVM = new GetRoleVM();
        getRoleVM.setId(item4Role.getId());
        getRoleVM.setRoleName(item4Role.getRoleName());
        getRoleVM.setRemark(item4Role.getRemark());
        getRoleVM.setRoleCode(item4Role.getRoleCode());
        List<Long> permIdList= rolePermissionList.stream().map(TbRolePermission::getPermissionId).collect(Collectors.toList());
        getRoleVM.setPermIds(permIdList);
        return getRoleVM;
    }
}
