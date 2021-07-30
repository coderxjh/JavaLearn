package com.xiao.rabbitmq.workqueues.two;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 测试手动应答、不公平分发、预取值
 * 生产者
 *
 * @author simba@onlying.cn
 * @date 2021/7/15 0:51
 */
public class Task02 {

    //队列名称
    public static final String TASK_QUEUE_NAME = "ack_queue";

    //发送大量消息
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //开启发布确认
        channel.confirmSelect();
        //设置queue（队列）持久化
        boolean durable=true;
        //声明队列
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);
        //从控制台当中接收信息
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.nextLine();
            /**
             * 发送一个消息
             * 1.发送到哪个交换机
             * 2.路由的Key值是哪个 本次是队列的名称
             * 3.其他参数
             */
            //设置生产者发送的消息为持久化消息（要求保持在磁盘中，不然是保持在内存中的）
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息" + message);
        }
    }
}