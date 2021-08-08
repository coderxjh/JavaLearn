package com.xiao.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author xjh
 * @create 2021-08-08 21:22
 */
@Mapper
public interface StorageDao {

    /**
     * 扣减账户余额
     */
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
