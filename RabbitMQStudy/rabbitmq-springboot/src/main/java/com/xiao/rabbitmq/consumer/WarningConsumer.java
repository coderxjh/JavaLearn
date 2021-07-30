package com.xiao.rabbitmq.consumer;

import com.xiao.rabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author simba@onlying.cn
 * @date 2021/7/19 15:15
 */
@Component
@Slf4j
public class WarningConsumer {

    @RabbitListener(queues = ConfirmConfig.WARNING_QUEUE_NAME)
    public void receiveWarningMsg(Message message) {
        String s = new String(message.getBody(), StandardCharsets.UTF_8);
        log.error("报警发现不可路由消息：{}" + s);
    }
}