package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.myhandler.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xjh
 * @create 2021-08-05 23:45
 */
@RestController
public class RateLimitController {

    /**
     * 测试Sentinel按资源名称定义限流规则，此方式可以自定义限流处理结果
     * @return
     */
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource", blockHandler = "handleException")
    public CommonResult byResource() {
        return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
    }

    /**
     * Sentinel按资源名称定义规则的限流处理结果
     * @param exception
     * @return
     */
    public CommonResult handleException(BlockException exception) {
        return new CommonResult(444, exception.getClass().getCanonicalName() + "\t 服务不可用");
    }

    /**
     * 测试Sentinel按Url地址定义限流规则，此方式会返回Sentinel自带的限流处理结果
     * @return
     */
    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }

    /**
     * 自定义通用的限流处理逻辑，
     * blockHandlerClass = CustomerBlockHandler.class
     * blockHandler = handleException2
     * 上述配置：找CustomerBlockHandler类里的handleException2方法进行兜底处理
     * 自定义通用的限流处理逻辑
     */
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class, blockHandler = "handleException2")
    public CommonResult customerBlockHandler() {
        return new CommonResult(200, "按客户自定义限流处理逻辑");
    }
}