package com.xiao.profile.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/7/8 16:11
 */
@Profile("test")
@Data
@Component
@ConfigurationProperties("person")
public class Worker implements Person {

    private String name;
    private Integer age;
}