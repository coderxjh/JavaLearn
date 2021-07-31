package com.xiao.beans;

import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 13:45
 */
@Component
public class Car {

    public Car() {
        System.out.println("car ... constructor...");
    }

    public void init() {
        System.out.println("car ... init...");
    }

    public void destroy() {
        System.out.println("car ... destroy...");
    }
}
