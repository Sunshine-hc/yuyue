package com.newer.yuyue.domain;

import java.io.Serializable;

/**
 * 角色实体类
 */
public class Authority implements Serializable {
    private Integer id;
    private AuthsrityName name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AuthsrityName getName() {
        return name;
    }

    public void setName(AuthsrityName name) {
        this.name = name;
    }
}
