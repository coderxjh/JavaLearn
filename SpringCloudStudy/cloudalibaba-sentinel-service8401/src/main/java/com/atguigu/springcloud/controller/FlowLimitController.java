package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xjh
 * @create 2021-08-04 22:59
 */
@RestController
@Slf4j
public class FlowLimitController {

    /**
     * 测试Sentinel的流量控制
     *
     * @return
     */
    @GetMapping("/testA")
    public String testA() {
        log.info(Thread.currentThread().getName() + "\t" + "...TestA");
        return "------testA";
    }

    /**
     * 测试Sentinel的流量控制
     *
     * @return
     */
    @GetMapping("/testB")
    public String testB() {
        log.info(Thread.currentThread().getName() + "\t" + "...TestB");
        return "------testB";
    }

    /**
     * 测试超时的Sentinel熔断策略
     *
     * @return
     */
    @GetMapping("/testC")
    public String testC() {
        log.info(Thread.currentThread().getName() + "\t" + "...TestC");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "------testC";
    }

    /**
     * 测试异常的Sentinel熔断策略
     *
     * @return
     */
    @GetMapping("/testD")
    public String testD() {
        log.info(Thread.currentThread().getName() + "\t" + "...TestD");
        //try {
        //    Thread.sleep(1000);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        int a = 10 / 0;
        return "------testB";
    }

    /**
     * @param p1
     * @param p2
     * @return
     * @SentinelResource 此注解表示，如果你违背了在Sentinel控制台上设置的规则，将会执行一个兜底的方法
     * blockHandler表示兜底方法的名字
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    // 此兜底方法必须加上BlockException类的参数，不然无法启动自定义的效果
    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey";
    }
}

