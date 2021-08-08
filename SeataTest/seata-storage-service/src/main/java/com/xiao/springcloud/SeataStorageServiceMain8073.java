package com.xiao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xjh
 * @create 2021-08-08 15:52
 */
@EnableDiscoveryClient
@SpringBootApplication
public class SeataStorageServiceMain8073 {

    public static void main(String[] args) {
        SpringApplication.run(SeataStorageServiceMain8073.class, args);
    }
}
