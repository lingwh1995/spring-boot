package com.dragonsoft;

import com.dragonsoft.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;

/**
 * @author ronin
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitTemplateTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 测试单播发送消息,点对点
     *      注意:默认序列机制是转换为base64格式的编码
     */
    @Test
    public void fun1(){
        //三个参数依次是:交换器 路由键 数据对象
            //只需要传入数据对象,会自动序列化该对象
        //convertAndSend(String exchange, String routingKey, final Object object)
        HashMap<String, String> message = new HashMap<>();
        message.put("message","hello rabbitmq");
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",message);
    }

    /**
     * 测试单播获取消息,点对点
     *      注意:测试时注掉RabbitServiceImpl中listen方的@RabbitListener注解
     */
    @Test
    public void fun2(){
        Object result = rabbitTemplate.receiveAndConvert("atguigu");
        System.out.println(result.getClass());
        System.out.println(result);
    }

    /**
     * 测试单播发送消息,点对点
     *      给消息队列中发送一个序列化了的user对象,并且测试@RabbitListener即使获取队列中的数据
     */
    @Test
    public void fun3(){
        User user = new User("001", "zhangsan", "lisi");
        rabbitTemplate.convertAndSend("exchange.direct","atguigu",user);
    }

    /**
     * 测试直接模式给队列中发送消息
     */
    @Test
    public void fun4(){
        User user = new User("001", "zhangsan", "lisi");
        rabbitTemplate.convertAndSend("test",user);
    }


    /**
     * 测试广播模式
     */
    @Test
    public void fun5(){
        User user = new User("001", "zhangsan", "lisi");
        rabbitTemplate.convertAndSend("exchange.fanout.boradcast","",user);
    }
}
