package com.dragonsoft.domain;

import java.io.Serializable;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:29
 */
public class SysRole implements Serializable{

    private static final long serialVersionUID = -2181272513615381665L;

    private Integer id;
    private String name;

    public SysRole() {
    }

    public SysRole(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
