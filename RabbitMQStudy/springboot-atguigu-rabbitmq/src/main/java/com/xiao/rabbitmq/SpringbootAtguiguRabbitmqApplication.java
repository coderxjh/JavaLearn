package com.xiao.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Rabbit自动配置
 * 1、RabbitAutoConfiguration
 * 2、有自动配置了连接工厂ConnectionFactory
 * 3、RabbitProperties封装了RabbitMQ的配置
 * 4、RabbitTemple：给RabbitMQ发送和接收消息
 * 5、AmqpAdmin：RabbitMQ系统管理功能组件
 *      创建和删除 Queue、Exchange、Binding
 * 6、@EnableRabbit +  @RabbitListener 监听消息队列的内容
 */
@SpringBootApplication
public class SpringbootAtguiguRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAtguiguRabbitmqApplication.class, args);
    }

}
