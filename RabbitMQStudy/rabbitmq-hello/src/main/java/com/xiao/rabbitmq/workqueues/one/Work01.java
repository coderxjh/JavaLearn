package com.xiao.rabbitmq.workqueues.one;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.xiao.rabbitmq.util.RabbitMQUtils;

/**
 * 测试工作队列
 * 这是一个工作线程（相当于之前的消费者）
 * @author simba@onlying.cn
 * @date 2021/7/15 0:41
 */
public class Work01 {

    //队列名称
    public static final String QUEUE_NAME="hello";

    //接收消息
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //声明成功消费时的接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息：" + new String(message.getBody()));
        };
        //声明取消消费时的接收消息
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费接口逻辑");
        };
        //消息的接收
        System.out.println("C2等待接收消息...");
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
