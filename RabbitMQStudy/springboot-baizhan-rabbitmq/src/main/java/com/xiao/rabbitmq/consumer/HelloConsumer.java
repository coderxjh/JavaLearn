package com.xiao.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/7/22 19:17
 */
@Component
@RabbitListener(queuesToDeclare = {@Queue("hello")})
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message) {
        System.out.println("message=" + message);
    }
}