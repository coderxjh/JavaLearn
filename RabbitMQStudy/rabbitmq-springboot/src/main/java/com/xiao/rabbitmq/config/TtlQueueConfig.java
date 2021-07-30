package com.xiao.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试基于TTL的延迟队列
 * TTL队列 配置文件类
 *
 * @author simba@onlying.cn
 * @date 2021/7/18 17:26
 */
@Configuration
public class TtlQueueConfig {

    //普通交换机的名称
    public static final String X_EXCHANGE = "X";
    //死信交换机的名称
    public static final String Y_DEAD_LETTER_EXCHANGE = "Y";
    //普通队列的名称
    public static final String QUEUE_A = "QA";
    public static final String QUEUE_B = "QB";
    public static final String QUEUE_C = "QC";
    //死信队列的名称
    public static final String DEAD_LETTER_QUEUE = "QD";

    //声明普通交换机
    @Bean("x_exchange")
    public DirectExchange xExchange() {
        return new DirectExchange(X_EXCHANGE);
    }

    //声明死信交换机
    @Bean("y_exchange")
    public DirectExchange yExchange() {
        return new DirectExchange(Y_DEAD_LETTER_EXCHANGE);
    }

    //声明普通队列 TTL为10S
    @Bean("queueA")
    public Queue queueA() {
        return QueueBuilder.durable(QUEUE_A)//声明持久化，设置queue名字
                .deadLetterExchange(Y_DEAD_LETTER_EXCHANGE)//设置死信交换机
                .deadLetterRoutingKey("YD")//设置死信RoutingKey
                .ttl(10000)//设置ttl
                .build();
    }

    //声明普通队列 TTL为40S
    @Bean("queueB")
    public Queue queueB() {
        return QueueBuilder.durable(QUEUE_B)//声明持久化，设置queue名字
                .deadLetterExchange(Y_DEAD_LETTER_EXCHANGE)//设置死信交换机
                .deadLetterRoutingKey("YD")//设置死信RoutingKey
                .ttl(40000)//设置ttl
                .build();
    }

    //声明普通队列 这个队列不声明TTL
    @Bean("queueC")
    public Queue queueC() {
        return QueueBuilder.durable(QUEUE_C)//声明持久化，设置queue名字
                .deadLetterExchange(Y_DEAD_LETTER_EXCHANGE)//设置死信交换机
                .deadLetterRoutingKey("YD")//设置死信RoutingKey
                .build();
    }

    @Bean("queueD")
    public Queue queueD() {
        return QueueBuilder.durable(DEAD_LETTER_QUEUE)//声明持久化，设置queue名字
                .build();
    }

    //绑定普通交换机和队列
    @Bean
    public Binding queueABindingX(@Qualifier("queueA") Queue queueA,
                                  @Qualifier("x_exchange") DirectExchange x_exchange) {
        return BindingBuilder.bind(queueA).to(x_exchange).with("XA");
    }

    //绑定普通交换机和队列
    @Bean
    public Binding queueBBindingX(@Qualifier("queueB") Queue queueB,
                                  @Qualifier("x_exchange") DirectExchange x_exchange) {
        return BindingBuilder.bind(queueB).to(x_exchange).with("XB");
    }

    //绑定普通交换机和队列
    @Bean
    public Binding queueCBindingX(@Qualifier("queueC") Queue queueC,
                                  @Qualifier("x_exchange") DirectExchange x_exchange) {
        return BindingBuilder.bind(queueC).to(x_exchange).with("XC");
    }

    //绑定死信交换机和队列
    @Bean
    public Binding queueDBindingY(@Qualifier("queueD") Queue queueD,
                                  @Qualifier("y_exchange") DirectExchange y_exchange) {
        return BindingBuilder.bind(queueD).to(y_exchange).with("YD");
    }
}