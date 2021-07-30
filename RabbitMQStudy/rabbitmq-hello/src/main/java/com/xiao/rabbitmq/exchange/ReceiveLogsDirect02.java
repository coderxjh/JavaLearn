package com.xiao.rabbitmq.exchange;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * 测试Direct交换机
 * 消费者
 */
public class ReceiveLogsDirect02 {
    private static final String EXCHANGE_NAME = "direct_logs";
    private static final String QUEUE_NAME = "console";

    public static void main(String[] argv) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        channel.exchangeDeclare("direct_logs", BuiltinExchangeType.DIRECT);
        channel.queueDeclare("console", false, false, false, null);
        channel.queueBind("console", "direct_logs", "info");
        channel.queueBind("console", "direct_logs", "warning");
        System.out.println("等待接收消息........... ");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            System.out.println(" 接收绑定键 :" +
                    delivery.getEnvelope().getRoutingKey() + ",消息:" + message);
        };
        channel.basicConsume("console", true, deliverCallback, consumerTag -> {
        });
    }
}