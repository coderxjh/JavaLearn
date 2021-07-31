package com.xiao.autoconfigure.service;

import com.xiao.autoconfigure.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 默认不要放在容器中
 * @author simba@onlying.cn
 * @date 2021/7/8 18:15
 */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName) {
        return helloProperties.getPrefix() + userName + helloProperties.getSuffix();
    }
}