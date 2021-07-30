package com.xiao.rabbitmq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.sun.org.apache.regexp.internal.REUtil;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 测试发布确认
 * 发布确认模式
 * 1、单个确认
 * 2、批量确认
 * 3、异步确认
 *
 * @author simba@onlying.cn
 * @date 2021/7/15 18:43
 */
public class ConfirmMessage {


    public static void main(String[] args) throws Exception {
        //1、单个确认    发布1000条单独确认消息耗时：531ms
//        publishMessageIndividually();
        //2、批量确认    发布1000条批量确认消息的耗时：140ms
//        publishMessageBatch();
        //3、异步确认      发布1000条异步确认消息的耗时：47ms
        publishMessageAsync();
    }

    //1、单个确认
    public static void publishMessageIndividually() throws Exception {
        //获取信道
        Channel channel = RabbitMQUtils.getChannel();
        //队列声明
        String queue = UUID.randomUUID().toString();
        channel.queueDeclare(queue, true, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        //开始时间
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            String message = i + "";
            channel.basicPublish("", queue, null, message.getBytes(StandardCharsets.UTF_8));
            //单个消息就马上进行发布确认
            //服务端返回 false 或超时时间内未返回，生产者可以消息重发
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发布完成");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布1000条单独确认消息耗时：" + (end - begin) + "ms");
    }

    //2、批量确认
    public static void publishMessageBatch() throws Exception {
        //获取信道
        Channel channel = RabbitMQUtils.getChannel();
        //队列声明
        String queue = UUID.randomUUID().toString();
        channel.queueDeclare(queue, true, false, false, null);
        //开启发布确认
        channel.confirmSelect();
        //开始时间
        long begin = System.currentTimeMillis();
        //批量发送消息,批量发布确认
        for (int i = 0; i < 1000; i++) {
            String message = i + "";
            channel.basicPublish("", queue, null, message.getBytes(StandardCharsets.UTF_8));
            if (i % 100 == 0) {
                //发布确认
                channel.waitForConfirms();
            }
        }
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("发布1000条批量确认消息的耗时：" + (end - begin) + "ms");
    }

    //3、异步确认
    public static void publishMessageAsync() throws Exception {
        //1.获取信道
        Channel channel = RabbitMQUtils.getChannel();
        //2.队列声明
        String queue = UUID.randomUUID().toString();
        channel.queueDeclare(queue, true, false, false, null);
        //3.开启发布确认
        channel.confirmSelect();
        //开始时间
        long begin = System.currentTimeMillis();

        /**
         * 线程安全有序的哈希表 适用于高并发的情况下
         * 1.轻松的将序号与消息进行关联
         * 2.轻松批量删除条目，只有给到序号
         * 3.支持高并发（多线程）
         */
        ConcurrentSkipListMap<Long, String> outstandingConfirms = new ConcurrentSkipListMap<>();

        //参数一：消息的标记 参数二：是否为批量确认
        ConfirmCallback ackCallback = (deliveryTag, multiple) -> {
            //2.删除掉已经确认的消息
            if (multiple) {
                //返回的是小于等于当前序列号的未确认消息 是一个 map
                ConcurrentNavigableMap<Long, String> confirmed = outstandingConfirms.headMap(deliveryTag);
                confirmed.clear();
            }else {
                //只清除当前序列号的消息
                outstandingConfirms.remove(deliveryTag);
            }
            System.out.println("确认的消息：" + deliveryTag);
        };
        ConfirmCallback nackCallback = (deliveryTag, multiple) -> {
            //3.打印未确认的消息
            System.out.println("未确认的消息：" + deliveryTag);
        };
        /**
         * 添加一个异步确认的监听器
         * 1.确认收到消息的回调
         * 2.未收到消息的回调
         */
        channel.addConfirmListener(ackCallback, nackCallback);
        //4.开始批量发送消息
        for (int i = 0; i < 1000; i++) {
            String message = "消息" + i;
            channel.basicPublish("", queue, null, message.getBytes(StandardCharsets.UTF_8));
            //1.此时记录下所有要发送的消息
            outstandingConfirms.put(channel.getNextPublishSeqNo(), message);
        }
        //结束时间
        long end = System.currentTimeMillis();
        System.out.println("发布1000条异步确认消息的耗时：" + (end - begin) + "ms");
    }
}