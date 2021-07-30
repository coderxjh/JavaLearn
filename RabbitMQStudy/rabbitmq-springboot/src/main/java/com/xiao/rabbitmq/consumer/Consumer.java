package com.xiao.rabbitmq.consumer;

import com.xiao.rabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/7/18 21:24
 */
@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveConfirmMessage(Message message) {
        log.info("接受到的队列confirm.queue消息：{}", new String(message.getBody()));
    }
}