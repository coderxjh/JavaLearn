package com.xiao.springcloud.service;

import com.xiao.springcloud.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author xjh
 * @create 2021-08-08 21:06
 */
@Service
@FeignClient(value = "seata-account-service",path = "/account")
public interface AccountService {

    /**
     * 扣减账户余额
     * @param userId 账户id
     * @param money 需要扣减的钱
     * @return 返回是否成功的结果
     */
    @PostMapping("/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
