package com.xiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xjh
 * @create 2021-08-08 15:23
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class SeataOrderServiceMain8071 {

    public static void main(String[] args) {
        SpringApplication.run(SeataOrderServiceMain8071.class,args);
    }
}