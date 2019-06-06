package com.yzd.shiro.web.api.config.shiro;

/**
 * 当前Token的实体类
 */
public class CurrentToken {
    /**
     * 当前用户ID
     */
    private Long id;
    /**
     * 当前用户名
     */
    private String name;
    /**
     * 唯一性标识：可用于用户没有登录的情况下
     */
    private String uuid;
    /**
     * 数据结构版本
     */
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
