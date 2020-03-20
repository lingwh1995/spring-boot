package com.dragonsoft.service;

import com.dragonsoft.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 测试 直接消费模式+@RabbitListener+@RabbitHandler
 * @author ronin
 */
@Service
@RabbitListener(queues = {"test"})
public class DirectServiceImpl implements DirectService{

    @Override
    @RabbitHandler
    public void monitor(User user) {
        System.out.println("--------------------");
        System.out.println("从队列中获得的内容:"+user);
        System.out.println("--------------------");
    }
}
