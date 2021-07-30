package com.xiao.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author simba@onlying.cn
 * @date 2021/7/21 23:50
 */
@Configuration
public class RabbitMqConfig {

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("exchange.direct",true,false);
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.durable("atguigu.news").build();
    }

    @Bean
    public Binding binding(@Qualifier("queue") Queue queue,
                           @Qualifier("directExchange") DirectExchange directExchange) {
        return BindingBuilder.bind(queue).to(directExchange).with("atguigu.news");
    }

    //设置json格式的消息序列化
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }
}
