package com.dragonsoft.service;

import com.dragonsoft.dao.SysUserMapper;
import com.dragonsoft.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:37
 */
@Service
public class SysUserServiceImpl implements ISysUserService{

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser selectById(Integer id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public SysUser selectByName(String name) {
        return sysUserMapper.selectByName(name);
    }
}
