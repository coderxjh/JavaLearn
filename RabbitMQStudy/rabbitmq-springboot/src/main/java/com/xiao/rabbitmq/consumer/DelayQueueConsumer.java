package com.xiao.rabbitmq.consumer;

import com.xiao.rabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 测试基于插件的延迟队列
 * 消费者
 *
 * @author simba@onlying.cn
 * @date 2021/7/18 20:29
 */
@Component
@Slf4j
public class DelayQueueConsumer {

    @RabbitListener(queues = DelayedQueueConfig.DELAYED_QUEUE_NAME)
    public void receiveDelayQueue(Message message) {
        String msg = new String(message.getBody());
        log.info("当前时间：{},收到延迟队列的消息：{}",new Date(),msg);
    }
}
