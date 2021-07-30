package com.xiao.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author simba@onlying.cn
 * @date 2021/7/22 19:13
 */
@SpringBootTest
public class TestRabbitMQ {

    //注入RabbitTemplate
    @Autowired
    RabbitTemplate rabbitTemplate;

    //hello world
    @Test
    public void testHello() {
        rabbitTemplate.convertAndSend("hello", "hello world");
    }

    //work queue
    @Test
    public void testWorkQueue() {
        for (int i = 1; i < 11; i++) {
            rabbitTemplate.convertAndSend("work", "work模型"+i);
        }
    }

    //fanout
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","fanout模型");
    }

    //direct
    @Test
    public void testDirect(){
        rabbitTemplate.convertAndSend("directs","info","发送info的key的路由信息");
    }

    //topic
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save的路由信息");
    }
}
