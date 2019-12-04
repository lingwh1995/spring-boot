package com.dragonsoft.service;

import com.dragonsoft.dao.SysUserRoleMapper;
import com.dragonsoft.domain.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 13:18
 */
@Service
public class SysUserRoleServiceImpl implements ISysUserRoleService{

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * @param userId 用户角色权限对应信息
     * @return
     */
    @Override
    public List<SysUserRole> listByUserId(String userId) {
        return sysUserRoleMapper.listByUserId(userId);
    }
}
