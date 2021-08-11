package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author xjh
 * @create 2021-08-07 14:58
 */
@Mapper
public interface OrderDao {

    /**
     * 1、新建订单
     *
     * @param order
     */

    void create(Order order);

    /**
     * 2、修改订单状态，从0改为1
     *
     * @param userId
     * @param status
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
