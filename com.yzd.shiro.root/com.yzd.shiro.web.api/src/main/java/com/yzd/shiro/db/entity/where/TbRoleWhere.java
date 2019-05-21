package com.yzd.shiro.db.entity.where;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class TbRoleWhere {
    private List<Long> roleId4InList=new ArrayList<>();
}
