package com.xiao.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/7/22 19:33
 */
@Component
public class WorkConsumer {

    //消费者1
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message) {
        System.out.println("message1=" + message);
    }

    //消费者2
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message) {
        System.out.println("message2=" + message);
    }
}
