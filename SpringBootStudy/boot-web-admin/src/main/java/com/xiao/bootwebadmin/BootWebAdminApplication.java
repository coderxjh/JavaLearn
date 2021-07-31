package com.xiao.bootwebadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;

//@ServletComponentScan(basePackages = "com.xiao.bootwebadmin")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
@MapperScan("com.xiao.bootwebadmin.mapper")
public class BootWebAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminApplication.class, args);
    }
}