package com.xiao.rabbitmq.deadqueues;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试死信队列
 * 消费者
 *
 * @author simba@onlying.cn
 * @date 2021/7/18 14:27
 */
public class Consumer02 {

    //死信交换机
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //消费者接收消息
        System.out.println("等待消费者接收消息...");
        channel.basicConsume(DEAD_QUEUE, true, (consumerTag, message) -> {
            System.out.println("Consumer02接收的消息====>" + new String(message.getBody(), StandardCharsets.UTF_8));
        }, consumerTag -> {
        });
    }
}