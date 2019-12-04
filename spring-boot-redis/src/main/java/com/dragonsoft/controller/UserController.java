package com.dragonsoft.controller;

import com.dragonsoft.domain.User;
import com.dragonsoft.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author ronin
 */
@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    public User getUserById(String id){
        return userService.getUserById(id);
    }
}
