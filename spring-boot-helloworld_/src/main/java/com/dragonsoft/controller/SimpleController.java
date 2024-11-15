package com.dragonsoft.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ronin
 */
@Controller
public class SimpleController {

    @RequestMapping("/hello")
    @ResponseBody
    public String helloworld(){
        return "hello,world!";
    }
}
