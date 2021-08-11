package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author xjh
 * @create 2021-08-03 19:49
 */
@FeignClient("nacos-payment-provider")
@Component
public interface PaymentFeignService {

    @GetMapping(value = "/payment/nacos/{id}")
    String getPayment(@PathVariable("id") Integer id) ;
}
