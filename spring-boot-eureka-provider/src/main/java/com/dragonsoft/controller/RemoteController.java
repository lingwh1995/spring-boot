package com.dragonsoft.controller;

import com.dragonsoft.service.IRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * @author ronin
 */
@Controller
public class RemoteController {

    @Autowired
    private IRemoteService remoteService;

    @Value("${server.port}")
    private String serverPort;

    @Value("${eureka.instance.instance-id}")
    private String nodeName;

    /**
     * 测试url:
     *      http://localhost:8081/hello-provier
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello-provier")
    public String sayHello(){
        System.out.println("端口:"+serverPort);
        System.out.println("节点ID:"+nodeName);
        System.out.println("UUID:"+ UUID.randomUUID().toString());
        return remoteService.sayHello();
    }
}
