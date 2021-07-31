package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author simba@onlying.cn
 * @date 2021/7/23 18:23
 */
@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment getPayment(@Param("id") Long id);
}
