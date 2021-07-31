package com.xiao.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 13:58
 */
@Component
public class Cat implements InitializingBean, DisposableBean {

    public Cat() {
        System.out.println("cat constructor...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("cat... destroy...");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("cat... afterPropertiesSet...");
    }
}
