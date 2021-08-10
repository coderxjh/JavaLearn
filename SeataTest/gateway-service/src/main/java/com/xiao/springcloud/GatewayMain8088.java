package com.xiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xjh
 * @create 2021-08-10 16:47
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayMain8088 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayMain8088.class, args);
    }
}
