package com.dragonsoft.service;

import com.dragonsoft.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 测试@RabbitListener
 * @author ronin
 */
@Service
public class RaabitServiceImpl implements RaabitService{

    /**
     * 测试@RabbitListener,在web管理端给exchange.direct中发送如下json:
     *      {"id":"001","username":"zhangsan","password":"lisi"}
     * @param user
     */
    @Override
//    @RabbitListener(queues = {"atguigu"})
    public void listen(User user) {
        System.out.println(user);
    }
}
