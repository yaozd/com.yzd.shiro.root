package com.yzd.shiro.web.api.model.response.user;

import com.yzd.shiro.db.entity.table.TbRole;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.web.api.utils.dateExt.DateUtil2;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
public class GetListUserVM {
    private Long id;

    private String username;

    private String mobile;

    private String roleName;

    private String createTime;

    private Long roleId;

    private Integer jobStatus;

    public static GetListUserVM toVM(TbUser item) {
        GetListUserVM getListUserVM = new GetListUserVM();
        getListUserVM.setId(item.getId());
        getListUserVM.setUsername(item.getUsername());
        getListUserVM.setMobile(item.getMobile());
        getListUserVM.setJobStatus(item.getJobStatus());
        String createTime=DateUtil2.getDateStr(item.getGmtCreateTime(),"yyyy-MM-dd HH:mm:ss");
        getListUserVM.setCreateTime(createTime);
        return getListUserVM;
    }

    public static void toSetRoleId(GetListUserVM item, List<TbUserRole> itemList4TbUserRole) {
       Optional<TbUserRole> optionalTbUserRole= itemList4TbUserRole.stream().filter(m->m.getUserId()==item.getId()).findFirst();
       if(optionalTbUserRole.isPresent()){
           item.setRoleId(optionalTbUserRole.get().getRoleId());
       }
    }
    public static void toSetRoleName(GetListUserVM item, List<TbRole> itemList4TbRole) {
        Optional<TbRole> optionalRole= itemList4TbRole.stream().filter(m->m.getId()==item.getRoleId()).findFirst();
        if(optionalRole.isPresent()){
            item.setRoleName(optionalRole.get().getRoleName());
            return;
        }
        item.setRoleName("");
    }
}
