package com.xiao.hellotest.controller;

import com.xiao.autoconfigure.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba@onlying.cn
 * @date 2021/7/8 18:47
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping("/hello")
    public String sayHello(){
        return helloService.sayHello("李四");
    }
}
