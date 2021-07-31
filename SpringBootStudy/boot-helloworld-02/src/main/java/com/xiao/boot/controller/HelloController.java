package com.xiao.boot.controller;

import com.xiao.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author simba@onlying.cn
 * @date 2021/6/15 16:15
 */
@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("person")
    public Person person(){
        String userName = person.getUserName();
        System.out.println(userName);
        return person;
    }
}
