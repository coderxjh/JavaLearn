package com.xiao.profile.config;

import com.xiao.profile.bean.Color;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author simba@onlying.cn
 * @date 2021/7/8 16:15
 */
@Configuration
public class MyConfig {

    @Profile("prod")
    @Bean
    public Color red() {
        return new Color();
    }

    @Profile("test")
    @Bean
    public Color green() {
        return new Color();
    }

}
