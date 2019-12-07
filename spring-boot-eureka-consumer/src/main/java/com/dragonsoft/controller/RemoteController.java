package com.dragonsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

/**
 * @author ronin
 */
@Controller
public class RemoteController {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 测试url:
     *      http://localhost:8083/hello-consumer
     * 用两个不同的端口启动服务提供者,通过测试url访问,查看cmd控制台负载均衡是否生效
     * @return
     */
    @ResponseBody
    @RequestMapping("/hello-consumer")
    public String sayHello(){
        return restTemplate.getForObject("http://FIRST-EUREKA-PROVIDER/hello-provier",String.class);
    }
}
