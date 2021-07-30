package com.xiao.rabbitmq.deadqueues;

import com.rabbitmq.client.*;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.io.IOException;
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
public class Consumer01 {

    //普通交换机
    public static final String NORMAL_EXCHANGE = "normal_exchange";
    //死信交换机
    public static final String DEAD_EXCHANGE = "dead_exchange";
    //普通队列
    public static final String NORMAL_QUEUE = "normal_queue";
    //死信队列
    public static final String DEAD_QUEUE = "dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //声明死信和普通交换机 类型为direct
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE, BuiltinExchangeType.DIRECT);
        //声明死信和普通对列
        Map<String, Object> arguments = new HashMap<>();
        //设置过期时间 也可以由生产者发消息时指定过期时间
//        arguments.put("x-message-ttl", 10000);
        //正常队列设置死信交换机,key是固定值
        arguments.put("x-dead-letter-exchange", DEAD_EXCHANGE);
        //设置死信RoutingKey
        arguments.put("x-dead-letter-routing-key", "lisi");
        //设置正常队列的长度限制
//        arguments.put("x-max-length", 6);
        channel.queueDeclare(NORMAL_QUEUE, false, false, false, arguments);
        channel.queueDeclare(DEAD_QUEUE, false, false, false, null);
        //绑定普通交换机和对列
        channel.queueBind(NORMAL_QUEUE, NORMAL_EXCHANGE, "zhangsan");
        //绑定死信交换机和对列
        channel.queueBind(DEAD_QUEUE, DEAD_EXCHANGE, "lisi");
        //消费者接收消息
        System.out.println("等待消费者接收消息...");
        channel.basicConsume(NORMAL_QUEUE, false, (consumerTag, message) -> {
            String s = new String(message.getBody(), StandardCharsets.UTF_8);
            if (s.equals("info=5")) {
                System.out.println("Consumer01接收的消息====>" + s + "此消息被拒绝");
                //第二个参数为true，消息将重新入队，false将消息丢弃或者进入死信队列
                channel.basicReject(message.getEnvelope().getDeliveryTag(),false);
            } else {
                System.out.println("Consumer01接收的消息====>" + s);
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
            }
        }, consumerTag -> {
        });
    }
}