package com.xiao.rabbitmq.workqueues.two;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * 测试手动应答、不公平分发、预取值
 * 消息在手动应答时是不丢失、放回队列中重新消费
 *
 * @author simba@onlying.cn
 * @date 2021/7/15 15:53
 */
public class Work02 {

    //队列名称
    public static final String TASK_QUEUE_NAME = "ack_queue";

    //接受消息
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        System.out.println("C1等待接受消息处理时间较短...");
        //声明成功消费时的接收消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            //沉睡1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("接收到的消息：" + new String(message.getBody(), StandardCharsets.UTF_8));
            //手动应答
            /**
             * 1.消息的标记 tag
             * 2.是否批量应答 false,不批量应答信道中的消息
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
        };
        //声明取消消费时的接收消息
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag + "消费者取消消费接口逻辑");
        };
        /**
         * 1.设置不公平分发
         * int prefetchCount=1
         * 2.设置预取值
         * int prefetchCount=2
         */
        channel.basicQos(2);
        //采用手动应答
        boolean autoAsk = false;
        channel.basicConsume(TASK_QUEUE_NAME, autoAsk, deliverCallback, cancelCallback);
    }
}