package com.dragonsoft.service;

import com.dragonsoft.domain.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:37
 */
public interface ISysUserService {

    /**
     * 根据用户id查询从SYS_USER中查询用户信息
     * @param id 用户id
     * @return
     */
    SysUser selectById(Integer id);

    /**
     * 根据用户name从SYS_USER中查询用户信息
     * @param name 用户姓名
     * @return
     */
    SysUser selectByName(String name);
}
