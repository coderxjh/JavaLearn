package com.xiao.rabbitmq.exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * 测试主题交换机及相关队列
 * 消费者 收消息
 *
 * @author simba@onlying.cn
 * @date 2021/7/16 19:50
 */
public class ReceiveLogsTopic01 {


    public static void main(String[] args) throws Exception {
        //1.获取信道
        Channel channel = RabbitMQUtils.getChannel();
        //2.声明交换器
        channel.exchangeDeclare("topic_logs", "topic");
        //3.声明队列
        channel.queueDeclare("Q1", false, false, false, null);
        //4.绑定队列与交换器
        channel.queueBind("Q1", "topic_logs", "*.orange.*");
        System.out.println("等待接收消息...");
        //5.接收消息
        channel.basicConsume("Q1", true, (consumerTag, message) -> {
            System.out.println(new String(message.getBody(), StandardCharsets.UTF_8));
            System.out.println("接收队列："+"Q1"+" 绑定键："+message.getEnvelope().getRoutingKey());
        }, consumerTag -> {});
    }
}