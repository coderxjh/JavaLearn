package com.xiao.rabbitmq.deadqueues;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.impl.AMQBasicProperties;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * 测试死信队列
 * 生产者
 *
 * @author simba@onlying.cn
 * @date 2021/7/18 14:47
 */
public class Producer {

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //死信消息 设置TTL时间
        AMQP.BasicProperties properties = new AMQP.BasicProperties()
                .builder().expiration("10000").build();
        for (int i = 1; i < 11; i++) {
            String message = "info=" + i;
            channel.basicPublish("normal_exchange", "zhangsan", null, message.getBytes(StandardCharsets.UTF_8));
        }
    }
}