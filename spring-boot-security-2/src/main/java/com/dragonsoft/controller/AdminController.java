package com.dragonsoft.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/4 9:07
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello,World!";
    }

    @GetMapping("/login")
    public String login() {
        return "login sucess";
    }
}
