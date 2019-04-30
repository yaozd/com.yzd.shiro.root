package com.yzd.shiro.web.api.model.response.a1base;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据结果
 * @param <T>
 */
@Data
@NoArgsConstructor
public class PageDataResult<T> implements Serializable {
    private List<T> dataList=new ArrayList<>();
    private Integer total;
}