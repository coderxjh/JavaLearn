package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xjh
 * @create 2021-07-27 0:22
 */
@Configuration
public class MySelfRule {
  @Bean
  public IRule myRule() {
    // 定义为随机
    return new RandomRule();
  }
}