package com.yzd.shiro.db.entity.where;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 扩展查询条件
 */
@Data
@NoArgsConstructor
public class TbUserWhere {
    private String username4LikeRight;
    private Date gmtCreateTime4Start;
    private Date gmtCreateTime4End;
}
