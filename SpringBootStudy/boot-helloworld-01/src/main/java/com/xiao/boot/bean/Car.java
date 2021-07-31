package com.xiao.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 只有在容器中的组件，才会拥有SpringBoot提供的强大功能
 * @author simba@onlying.cn
 * @date 2021/6/13 17:56
 */
//@Component
@ConfigurationProperties(prefix = "mycar")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    private String brand;
    private Integer price;
    private Pet pet;
}