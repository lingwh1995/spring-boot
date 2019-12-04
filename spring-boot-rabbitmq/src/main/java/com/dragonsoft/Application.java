package com.dragonsoft;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * SpringBoot集成RabbitMQ:
 *      RabbitMQAutoConfiguration,包含了如下组件:
 *          自动配置的连接工厂ConntectionFactory
 *          RabbitTemplate:用来给RabbitMQ发送和接受消息
 *          AmqpAdmin:RabbitMQ系统管理功能组件
 *      如何实时监听消息队列中内容的变化:
 *          @EnableRabbit+@RabbitListerner
 * @author ronin
 */
@EnableRabbit
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
