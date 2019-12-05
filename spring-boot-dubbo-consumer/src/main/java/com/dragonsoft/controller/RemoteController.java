package com.dragonsoft.controller;

import com.alibaba.dubbo.config.annotation.Reference;
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

    @Reference(version = "1.0.0")
    private IRemoteService remoteService;


    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return remoteService.sayHello();
    }

}
