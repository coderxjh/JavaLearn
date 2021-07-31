package com.xiao.profile.controller;

import com.xiao.profile.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba@onlying.cn
 * @date 2021/7/8 15:46
 */
@RestController
public class HelloController {

    @Value("${person.name:李四}")
    private String name;

    @Autowired
    private Person person;

    @RequestMapping("/")
    public String hello(){
        return person.getClass().toString();
    }

    @GetMapping("/person")
    public Person person(){
        return person;
    }
}