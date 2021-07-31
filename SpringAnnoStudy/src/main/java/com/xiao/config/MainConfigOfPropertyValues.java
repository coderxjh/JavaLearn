package com.xiao.config;

import com.xiao.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 15:55
 */
@Configuration
//使用@PropertySource读取外部配置文件中的k/v保存到运行的环境变量中；
//加载完外部的配置文件以后使用${}取出配置文件的值
@PropertySource(value = {"classpath:person.properties"})
public class MainConfigOfPropertyValues {

    @Bean
    public Person person() {
        return new Person();
    }
}
