package com.xiao.springcloud.service;

import java.math.BigDecimal;

/**
 * @author xjh
 * @create 2021-08-08 21:28
 */
public interface StorageService {

    /**
     * 扣减库存
     *
     * @param productId 产品id
     * @param count     数量
     */
    void decrease(Long productId, Integer count);
}
