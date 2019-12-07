package com.dragonsoft.controller;

import com.dragonsoft.service.IRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ronin
 */
@Controller
public class RemoteController {

    @Autowired
    private IRemoteService remoteService;

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello(){
        return remoteService.sayHello();
    }
}
