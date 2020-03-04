package com.dragonsoft.dao.oracle;

import com.dragonsoft.domain.User;

import java.util.List;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/11/18 14:56
 */
public interface IUserDaoOracle {
    /**
     * 根据id获取User对象
     * @param id
     * @return
     */
    User getUserById(String id);

    /**
     * 获取所有的User
     * @return
     */
    List<User> getUsers();
}
