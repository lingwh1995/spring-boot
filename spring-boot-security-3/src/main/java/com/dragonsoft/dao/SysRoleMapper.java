package com.dragonsoft.dao;

import com.dragonsoft.domain.SysRole;
import org.apache.ibatis.annotations.Select;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:33
 */
public interface SysRoleMapper {

    /**
     * 根据id从SYS_ROLE表中查询用户权限
     * @param id 用户id
     * @return
     */
    @Select("SELECT * FROM SYS_ROLE WHERE ID = #{id}")
    SysRole selectById(Integer id);
}
