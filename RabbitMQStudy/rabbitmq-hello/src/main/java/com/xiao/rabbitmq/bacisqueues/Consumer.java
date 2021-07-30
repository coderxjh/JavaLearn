package com.xiao.rabbitmq.bacisqueues;

import com.rabbitmq.client.*;

import javax.swing.*;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 消费者代码
 *
 * @author simba@onlying.cn
 * @date 2021/7/14 23:59
 */
public class Consumer {

    //队列的名称
    public static final String QUEUE_NAME = "hello";

    //接收消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.242.138");
        factory.setUsername("admin");
        factory.setPassword("123");
        Connection connection = factory.newConnection();

        Channel channel = connection.createChannel();
        channel.exchangeDeclare("fed_exchange","direct");
        channel.queueDeclare("node2_queue",true,false,false,null);
        channel.queueBind("node2_queue","fed_exchange","routKey");


        //声明成功消费是的接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息：" + new String(message.getBody()));
        };
//        //声明取消消费时的接收消息
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费接口逻辑");
        };
//        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        /**
         * 消费者消费消息
         * 1.消费哪个队列
         * 2.消费成功之后是否要自动应答 true为自动应答 false为手动应答
         * 3.消费者成功消费的回调
         * 4.消费者取消消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }
}