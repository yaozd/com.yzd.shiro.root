package com.yzd.shiro.web.api.model.request.user;
import java.util.Date;
import java.util.Objects;
import java.util.stream.Stream;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbUser;
import com.yzd.shiro.db.entity.where.TbUserWhere;
import com.yzd.shiro.web.api.utils.dateExt.DateUtil2;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetListUserForm {
    private String username;
    private String mobile;
    private String insertTimeStart;
    private String insertTimeEnd;

    public static TbUser toEntity(GetListUserForm form) {
        TbUser tbUser = new TbUser();
        tbUser.setUsername(form.getUsername());
        tbUser.setMobile(form.getMobile());
        tbUser.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return tbUser;
    }
    public static TbUserWhere toEntity4Where(GetListUserForm form) {
        TbUserWhere where = new TbUserWhere();
        Date dt4Start=DateUtil2.getStartOfDay(form.insertTimeStart);
        Date dt4End=DateUtil2.getEndOfDay(form.insertTimeEnd);
        where.setGmtCreateTime4Start(dt4Start);
        where.setGmtCreateTime4End(dt4End);
        return where;
    }
}
