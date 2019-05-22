package com.yzd.shiro.web.api.model.request.user;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.enumExt.TbUserEnum;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.table.TbUserRole;
import com.yzd.shiro.web.api.utils.dateExt.DateUtil2;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class AddEditUserForm {
    private Long id;
    private String username;

    private String mobile;

    private String email;

    private String password;

    private List<Long> roleIds = new ArrayList<>();

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
    public static TbUserRole toEntity4TbUserRole(Long userId, Long roleId){
        TbUserRole tbUserRole=new TbUserRole ();
        tbUserRole.setUserId(userId);
        tbUserRole.setRoleId(roleId);
        String version = DateUtil2.getDateStr(new Date(), "yyyyMMddHHmmss");
        tbUserRole.setVersion(version);
        tbUserRole.setGmtCreateTime(new Date());
        tbUserRole.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return tbUserRole;
    }
    public static TbUserRole toEntity4TbUserRole2Delete(Long userId){
        TbUserRole tbUserRole=new TbUserRole ();
        tbUserRole.setUserId(userId);
        tbUserRole.setGmtIsDel(TbPublicEnum.gmtIsDel.YES.CODE);
        return tbUserRole;
    }
}
