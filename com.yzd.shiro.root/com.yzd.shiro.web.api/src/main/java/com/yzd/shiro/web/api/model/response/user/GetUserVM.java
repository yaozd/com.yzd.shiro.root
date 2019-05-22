package com.yzd.shiro.web.api.model.response.user;

import com.yzd.shiro.db.entity.table.TbUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserVM {
    private Long id;
    private String username;

    private String mobile;

    private String email;

    private String password;

    private Long roleId;

    public static GetUserVM toVM(TbUser item4User,Long roleId) {
        GetUserVM getUserVM = new GetUserVM();
        getUserVM.setId(item4User.getId());
        getUserVM.setUsername(item4User.getUsername());
        getUserVM.setMobile(item4User.getMobile());
        getUserVM.setEmail(item4User.getEmail());
        getUserVM.setPassword(item4User.getPassword());
        getUserVM.setRoleId(roleId);
        return getUserVM;
    }
}
