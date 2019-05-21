package com.yzd.shiro.db.entity.where;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TbUserRoleWhere {
    private List<Long> userId4InList=new ArrayList<>();
}
