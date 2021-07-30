package com.xiao.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/7/22 20:13
 */
@Component
public class TopicConsumer {

    @RabbitListener(bindings =
    @QueueBinding(value = @Queue,
            exchange = @Exchange(type = "topic", name = "topics"),
            key = {"user.save","user.*"})
    )
    public void receive1(String message) {
        System.out.println("message1="+message);
    }


    @RabbitListener(bindings =
    @QueueBinding(value = @Queue,
            exchange = @Exchange(type = "topic", name = "topics"),
            key = {"order.#","produce.#","user.*"})
    )
    public void receive2(String message) {
        System.out.println("message2="+message);
    }
}
