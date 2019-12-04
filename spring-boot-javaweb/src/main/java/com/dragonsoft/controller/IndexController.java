package com.dragonsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ronin
 */
@Controller
public class IndexController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","I am msg from IndexController!");
        return "hello";
    }
}
