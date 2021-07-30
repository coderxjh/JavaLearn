package com.xiao.rabbitmq.config;

import com.sun.org.apache.xml.internal.security.Init;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author simba@onlying.cn
 * @date 2021/7/19 14:03
 */
@Component
@Slf4j
public class MyCallBack implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnsCallback {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // 依赖注入完成后执行此注解标注的方法
    // 在rabbitTemplate完成依赖注入之后再设置它的回调对象
    @PostConstruct
    public void init() {
        rabbitTemplate.setConfirmCallback(this);
        rabbitTemplate.setReturnsCallback(this);
    }

    /**
     * 交换机确认回调的方法
     *
     * @param correlationData 保存回调消息的ID及相关消息
     * @param ack             交换机收到消息 true 交换机没收到消息 false
     * @param cause           交换机接收到消息：null 没收到消息：失败的原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id = correlationData != null ? correlationData.getId() : "";
        if (ack) {
            log.info("交换机已经收到ID为{}的消息", id);
        } else {
            log.info("交换机未收到ID为{}的消息,原因：{}", id, cause);
        }
    }

    //可以在当消息传递过程中不可达目的地时将消息返回生产者
    //只有不可达目的地的时候 才进行回退
    @Override
    public void returnedMessage(ReturnedMessage returned) {
        log.error("被交换机{}退回,消息内容:{},退回原因:{},路由Key:{}",
                returned.getExchange(),
                new String(returned.getMessage().getBody()),
                returned.getReplyText(),
                returned.getRoutingKey());
    }
}