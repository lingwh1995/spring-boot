package com.dragonsoft.service;

import com.dragonsoft.domain.SysRole;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:39
 */
public interface ISysRoleService {

    /**
     * 根据id从SYS_ROLE表中查询用户权限
     * @param id 用户id
     * @return
     */
    SysRole selectById(Integer id);
}

