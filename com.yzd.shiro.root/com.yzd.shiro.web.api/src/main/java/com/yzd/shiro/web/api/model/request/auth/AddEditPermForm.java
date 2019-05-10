package com.yzd.shiro.web.api.model.request.auth;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddEditPermForm {
    private Long id;

    private String name;

    private String permissionCode;

    private Integer sortNo;

    private Integer visibleStatus;

    private Integer enableStatus;

    private Integer permissionType;

    private String url;

    private Long parentId;

    private String remark;
}
