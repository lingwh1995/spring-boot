package com.dragonsoft.domain;

import java.io.Serializable;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:24
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = -6065609494649868233L;

    private String id;
    private String name;
    private String password;

    public SysUser() {
    }

    public SysUser(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
