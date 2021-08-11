package com.atguigu.springcloud.service;

/**
 * @author xjh
 * @create 2021-08-07 19:41
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
