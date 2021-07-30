package com.xiao.rabbitmq.exchange;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * 测试fanout交换机
 * 消费者 接收消息
 * @author simba@onlying.cn
 * @date 2021/7/15 23:28
 */
public class ReceiveLog01 {

    public static final String EXCHANGE_NAME = "logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        /**
         * 生成一个临时队列、队列的名称是随机的
         * 当消费者断开与队列的连接的时候 队列就会自动删除
         */
        String queue = channel.queueDeclare().getQueue();
        //绑定交换机与队列
        channel.queueBind(queue, EXCHANGE_NAME, "");
        System.out.println("等待接受消息，把接收到消息打印在屏幕上....");
        //接收消息
        channel.basicConsume(queue, true, new DeliverCallback() {
            @Override
            public void handle(String consumerTag, Delivery message) {
                System.out.println(consumerTag + "==控制台打印接收到的消息:" + new String(message.getBody(), StandardCharsets.UTF_8));
            }
        }, consumerTag -> {

        });
    }
}
