package com.dragonsoft.service;

import com.dragonsoft.domain.User;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * 测试广播模式
 * @author ronin
 */
@Service
public class FanoutServiceImpl implements FanoutService{

    @Override
    @RabbitListener(queues = {"broadcast_queue_1"})
    public void monitor1(User user) {
        System.out.println("broadcast_queue_1:"+user);
    }

    @Override
    @RabbitListener(queues = {"broadcast_queue_2"})
    public void monitor2(User user) {
        System.out.println("broadcast_queue_2:"+user);
    }

    @Override
    @RabbitListener(queues = {"broadcast_queue_3"})
    public void monitor3(User user) {
        System.out.println("broadcast_queue_3:"+user);
    }
}
