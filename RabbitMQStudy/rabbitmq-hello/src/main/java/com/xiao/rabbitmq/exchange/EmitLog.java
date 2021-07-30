package com.xiao.rabbitmq.exchange;

import com.rabbitmq.client.Channel;
import com.xiao.rabbitmq.util.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 测试fanout交换机
 * 生产者 发消息
 *
 * @author simba@onlying.cn
 * @date 2021/7/15 23:38
 */
public class EmitLog {

    public static final String EXCHANGE_NAME = "fanout_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.nextLine();
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出消息：" + message);
        }
    }
}