package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author xjh
 * @create 2021-07-28 17:16
 */
@Component
public class PaymentFallBackService implements PaymentHystrixService{
    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }

    @Override
    public String paymentInfoOk(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }
}
