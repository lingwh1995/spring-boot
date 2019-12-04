package com.dragonsoft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Properties;

/**
 * @author ronin
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitAMQPTest {

    @Autowired
    private AmqpAdmin amqpAdmin;

    /**
     * 测试创建Exchange(交换器)
     */
    @Test
    public void fun1(){
        amqpAdmin.declareExchange(new DirectExchange("exchange.direct.amqp"));
        System.out.println("创建完成");
    }

    /**
     * 测试创建一个支持持久化的Queue(消息队列)
     */
    @Test
    public void fun2(){
        amqpAdmin.declareQueue(new Queue("queue.amqp",true));
        System.out.println("创建完成");
    }

    /**
     * 需要先执行前两个测试
     * 创建Exhange和Queue的绑定规则
     */
    @Test
    public void fun3(){
        amqpAdmin.declareBinding(new Binding
                ("queue.amqp",Binding.DestinationType.QUEUE,"exchange.direct.amqp","test-router-key",null));
        System.out.println("绑定成功");
    }

    /**
     * 测试获取队列的信息
     */
    @Test
    public void fun4(){
        System.out.println("---------------------------------------------------");
        QueueInformation queueInfo = amqpAdmin.getQueueInfo("queue.amqp");
        System.out.println(queueInfo.toString());
        System.out.println("---------------------------------------------------");
        Properties queueProperties = amqpAdmin.getQueueProperties("queue.amqp");
        System.out.println(queueProperties.toString());
        System.out.println("---------------------------------------------------");
    }
}
