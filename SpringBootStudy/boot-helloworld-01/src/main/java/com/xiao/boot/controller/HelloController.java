package com.xiao.boot.controller;

import com.xiao.boot.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba@onlying.cn
 * @date 2021/6/13 17:02
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("car")
    public Car car() {
        return car;
    }

    @RequestMapping("hello2")
    public String handle01() {
        log.info("请求进来了...");
        return "Hello, Spring Boot 2!";
    }
}