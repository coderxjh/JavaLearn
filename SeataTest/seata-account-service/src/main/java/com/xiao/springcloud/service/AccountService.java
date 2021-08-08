package com.xiao.springcloud.service;

import java.math.BigDecimal;

/**
 * @author xjh
 * @create 2021-08-08 21:26
 */
public interface AccountService {

    /**
     * 扣减账户余额
     *
     * @param userId 账户id
     * @param money  金钱
     */
    void decrease(Long userId, BigDecimal money);
}
