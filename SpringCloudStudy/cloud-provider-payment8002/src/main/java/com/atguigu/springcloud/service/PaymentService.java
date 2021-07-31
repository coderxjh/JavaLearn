package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

/**
 * @author simba@onlying.cn
 * @date 2021/7/23 18:36
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPayment(Long id);
}