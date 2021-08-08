package com.xiao.springcloud.service;

import com.xiao.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xjh
 * @create 2021-08-08 21:07
 */
@FeignClient(value = "seata-storage-service",path = "/storage")
@Service
public interface StorageService {

    /**
     * 扣减库存余额
     * @param productId 库存id
     * @param count 需要扣减的数量
     * @return 返回是否成功的结果
     */
    @PostMapping("/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);


}
