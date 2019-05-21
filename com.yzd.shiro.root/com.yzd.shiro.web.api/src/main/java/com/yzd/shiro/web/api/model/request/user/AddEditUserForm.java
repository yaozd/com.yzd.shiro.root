package com.yzd.shiro.web.api.model.request.user;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.enumExt.TbUserEnum;
import com.yzd.shiro.db.entity.table.TbUser;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AddEditUserForm {
    private Long id;
    private String username;

    private String mobile;

    private String email;

    private String password;


    public static TbUser toEntity(AddEditUserForm form) {
        TbUser tbUser = new TbUser();
        tbUser.setId(form.getId());
        tbUser.setUsername(form.getUsername());
        tbUser.setMobile(form.getMobile());
        tbUser.setEmail(form.getEmail());
        tbUser.setPassword(form.getPassword());
        tbUser.setJobStatus(TbUserEnum.jobStatus.YES.CODE);
        tbUser.setVersion(1);
        tbUser.setGmtCreateTime(new Date());
        tbUser.setGmtUpdateTime(new Date());
        tbUser.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return tbUser;
    }
}
