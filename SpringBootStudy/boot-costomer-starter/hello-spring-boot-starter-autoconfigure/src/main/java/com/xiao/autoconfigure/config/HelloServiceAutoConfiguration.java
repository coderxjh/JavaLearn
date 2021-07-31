package com.xiao.autoconfigure.config;

import com.xiao.autoconfigure.bean.HelloProperties;
import com.xiao.autoconfigure.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author simba@onlying.cn
 * @date 2021/7/8 18:18
 */
@Configuration
@EnableConfigurationProperties(HelloProperties.class)
public class HelloServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService(){
        return new HelloService();
    }
}