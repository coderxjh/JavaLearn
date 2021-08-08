package com.xiao.springcloud.service.impl;

import com.xiao.springcloud.dao.OrderDao;
import com.xiao.springcloud.entity.Order;
import com.xiao.springcloud.service.AccountService;
import com.xiao.springcloud.service.OrderService;
import com.xiao.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author xjh
 * @create 2021-08-08 21:04
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private AccountService accountService;

    @Autowired
    private StorageService storageService;

    @GlobalTransactional(name = "my_test_tx_group",rollbackFor = Exception.class)
    @Override
    public void create(Order order) {
        log.info("----->开始新建订单");
        orderDao.create(order);

        log.info("----->order-service开始调用库存，扣减库存余额");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("----->order-service开始调用库存，扣减结束");

        log.info("----->order-service开始调用账户，扣减账户余额");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("----->order-service开始调用库存，扣减结束");

        int a= 10/0;
        //4.修改订单状态，从零到1，1代表已经完成
        log.info("------>order-service修改订单状态开始");
        orderDao.update(order.getUserId(), 1);
        log.info("------->order-service修改订单状态结束");

        log.info("------->下单结束");
    }
}
