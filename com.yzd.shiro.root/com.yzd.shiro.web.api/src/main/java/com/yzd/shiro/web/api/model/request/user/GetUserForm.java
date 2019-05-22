package com.yzd.shiro.web.api.model.request.user;

import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbUserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetUserForm {

    public static TbUserRole toEntity(Long id) {
        TbUserRole item=new TbUserRole();
        item.setUserId(id);
        item.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        return item;
    }
}
