package com.dragonsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试Springboot集成SpringSecurity框架
 * @author ronin
 * @version V1.0
 * @since 2019/12/3 9:40
 */
@Controller
public class SpringSecurityController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }
    @RequestMapping("/hello")
    public ModelAndView hello(ModelAndView mv) {
        mv.setViewName("hello");
        mv.addObject("message","I am message from /hello-request-mapping!");
        return mv;
    }

    /**
     * 测试url:
     *      http://localhost:8080/vip1
     * @param mv
     * @return
     */
    @RequestMapping("/vip1")
    public ModelAndView vip1(ModelAndView mv) {
        mv.setViewName("vip1");
        mv.addObject("message","I am message from /vip1-request-mapping!");
        return mv;
    }

}
