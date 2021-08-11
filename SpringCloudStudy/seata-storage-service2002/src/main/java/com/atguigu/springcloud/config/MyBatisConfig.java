package com.atguigu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xjh
 * @create 2021-08-07 15:38
 */
@Configuration
@MapperScan("com.atguigu.springcloud.dao")
public class MyBatisConfig {

}
