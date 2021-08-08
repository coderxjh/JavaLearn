package com.xiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xjh
 * @create 2021-08-08 15:22
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountServiceMain8072 {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountServiceMain8072.class, args);
    }
}
