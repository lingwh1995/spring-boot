package com.dragonsoft.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dragonsoft.domain.User;
import com.dragonsoft.service.IRemoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ronin
 * @version V1.0
 * @since 2019/12/5 14:49
 */
@Controller
public class RemoteController {

    @Reference
    private IRemoteService remoteService;

    /**
     * 测试获取字符串:
     *      http://localhost:8082/hello
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return remoteService.sayHello();
    }

    /**
     * 测试获取实例对象:
     *      http://localhost:8082/user
     * @return
     */
    @ResponseBody
    @RequestMapping("/user")
    public User getUser(){
        return remoteService.getUser();
    }
}
