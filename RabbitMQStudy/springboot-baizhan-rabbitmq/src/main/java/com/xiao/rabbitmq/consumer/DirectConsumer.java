package com.xiao.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/7/22 20:04
 */
@Component
public class DirectConsumer {

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs", type = "direct"),//声明一个交换机并定义它的类型
                    key = {"info", "error", "warn"}
            )
    )
    public void receive1(String message) {
        System.out.println("message1=" + message);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directs", type = "direct"),//声明一个交换机并定义它的类型
                    key = {"error"}
            )
    )
    public void receive2(String message) {
        System.out.println("message2=" + message);
    }
}
