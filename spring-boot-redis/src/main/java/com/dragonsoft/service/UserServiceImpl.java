package com.dragonsoft.service;

import com.dragonsoft.dao.UserDao;
import com.dragonsoft.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author ronin
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable(cacheNames = {"user"},key = "#id")
    public User getUserById(String id) {
        return userDao.getUserById(id);
    }
}
