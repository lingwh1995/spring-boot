package com.dragonsoft.domain;

import java.io.Serializable;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:30
 */
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = -5134656171385327227L;

    private Integer userId;
    private Integer roleId;

    public SysUserRole() {
    }

    public SysUserRole(Integer userId, Integer roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
