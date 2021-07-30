package com.xiao.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringbootAtguiguRabbitmqApplicationTests {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    AmqpAdmin amqpAdmin;

    @Test
    void testAmqp(){
        amqpAdmin.declareExchange(new DirectExchange("Y_exchange"));
        amqpAdmin.declareQueue(QueueBuilder.durable("Y_queue").build());
        amqpAdmin.declareBinding(new Binding("Y_queue",Binding.DestinationType.QUEUE, "Y_exchange","Y_amqp",null));
    }

    @Test
    void contextLoads() {
//        Message需要自己构造一个；定义消息体内容和消息头
//        rabbitTemplate.send(exchange,routKey,message);
//        object默认被当成消息体，只需要传入要发送的对象，自动序列化发送给rabbitmq
//        rabbitTemplate.convertAndSend(exchange,routKey,object);
        Map<String,Object> map=new HashMap<>();
        map.put("msg","第一个消息");
        map.put("data", Arrays.asList("helloworld",123,true));
        //对象被默认序列化以后发送出去
        rabbitTemplate.convertAndSend("exchange.direct","atguigu.news",map);
    }

    @Test
    public void receive(){
        Object o = rabbitTemplate.receiveAndConvert("atguigu.news");
        System.out.println(o.getClass());
        System.out.println(o);
    }
}
