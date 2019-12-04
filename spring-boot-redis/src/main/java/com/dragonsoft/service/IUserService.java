package com.dragonsoft.service;

import com.dragonsoft.domain.User;

/**
 * @author ronin
 */
public interface IUserService {

    /**
     * 根据id获取User
     * @param id
     * @return
     */
    User getUserById(String id);
}
