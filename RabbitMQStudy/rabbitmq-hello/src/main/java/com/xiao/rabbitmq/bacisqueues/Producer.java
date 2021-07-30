package com.xiao.rabbitmq.bacisqueues;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;


/**
 * 生产者代码
 *
 * @author simba@onlying.cn
 * @date 2021/7/14 23:40
 */
public class Producer {

    //队列名称
    public static final String QUEUE_NAME = "mirror_hello";

    //发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //工厂IP 连接RabbitMQ的队列
        factory.setHost("192.168.242.138");
        //用户名
        factory.setUsername("admin");
        //密码
        factory.setPassword("123");
        //创建连接
        //channel 实现了自动 close 接口 自动关闭 不需要显示关闭
        Connection connection = factory.newConnection();
        //获取信道
        Channel channel = connection.createChannel();
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化（磁盘） 默认情况消息存储在内存汇总
         * 3.该队列是否只供一个消费者进行消费，是否进行消息共享，true可以多个消费者消费
         * 4.是否自动删除，最后一个消费者端开连接后，该队列是否自动删除，true为自动删除
         * 5.其他参数
         */
        Map<String, Object> arguments = new HashMap<>();
        //官方允许范围在0~255之间，此处设置10 允许优化级范围为0~10 ；不要设置过大，浪费CPU内存
        arguments.put("x-max-priority", 10);
        channel.queueDeclare(QUEUE_NAME, true, false, false, arguments);
        //发消息
        for (int i = 1; i < 11; i++) {
            String message = "info" + i;
            if (i == 5) {
                AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().priority(5).build();
                /**
                 * 发送一个消息
                 * 1.发送到哪个交换机
                 * 2.路由的Key值是哪个 本次是队列的名称
                 * 3.其他参数
                 */
                channel.basicPublish("", QUEUE_NAME, properties, message.getBytes(StandardCharsets.UTF_8));
            } else {
                channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            }
        }
        System.out.println("消息发送");
    }
}
