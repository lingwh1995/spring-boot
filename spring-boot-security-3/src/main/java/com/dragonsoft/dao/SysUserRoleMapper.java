package com.dragonsoft.dao;

import com.dragonsoft.domain.SysUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:34
 */
public interface SysUserRoleMapper {

    /**
     * 根据userId从SYS_USER_ROLE中
     * @param userId 用户角色权限对应信息
     * @return
     */
    @Select("SELECT * FROM SYS_USER_ROLE WHERE USER_ID = #{userId}")
    List<SysUserRole> listByUserId(String userId);
}
