package com.xiao.rabbitmq.workqueues.one;

import com.rabbitmq.client.Channel;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 测试工作队列
 * 生产者 发送大量消息
 *
 * @author simba@onlying.cn
 * @date 2021/7/15 0:51
 */
public class Task01 {

    //队列名称
    public static final String QUEUE_NAME = "hello";

    //发送大量消息
    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        /**
         * 生成一个队列
         * 1.队列名称
         * 2.队列里面的消息是否持久化（磁盘） 默认情况消息存储在内存汇总
         * 3.该队列是否只供一个消费者进行消费，是否进行消息共享，true可以多个消费者消费
         * 4.是否自动删除，最后一个消费者端开连接后，该队列是否自动删除，true为自动删除
         * 5.其他参数
         */
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
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
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("消息发送完成" + message);
        }
    }
}