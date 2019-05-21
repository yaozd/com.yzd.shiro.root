package com.yzd.shiro.web.api.model.response.user;

import com.yzd.shiro.db.entity.table.TbUser;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetListUserVM {
    private Long id;

    private String username;

    private String mobile;

    private String roleName;

    private Integer jobStatus;

    public static GetListUserVM toVM(TbUser item) {
        GetListUserVM getListUserVM = new GetListUserVM();
        getListUserVM.setId(item.getId());
        getListUserVM.setUsername(item.getUsername());
        getListUserVM.setMobile(item.getMobile());
        getListUserVM.setJobStatus(item.getJobStatus());
        return getListUserVM;
    }
}
