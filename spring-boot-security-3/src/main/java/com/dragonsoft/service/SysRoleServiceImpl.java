package com.dragonsoft.service;

import com.dragonsoft.dao.SysRoleMapper;
import com.dragonsoft.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 11:39
 */
@Service
public class SysRoleServiceImpl implements ISysRoleService{

    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRole selectById(Integer id){
        return sysRoleMapper.selectById(id);
    }
}
