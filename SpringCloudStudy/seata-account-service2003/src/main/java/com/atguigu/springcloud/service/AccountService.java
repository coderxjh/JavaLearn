package com.atguigu.springcloud.service;

import java.math.BigDecimal;

/**
 * @author xjh
 * @create 2021-08-07 19:57
 */
public interface AccountService {

    /**
     * 扣减账户余额
     */
    void decrease(Long userId, BigDecimal money);
}
