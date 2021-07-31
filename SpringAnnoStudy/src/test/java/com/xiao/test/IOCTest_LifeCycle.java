package com.xiao.test;

import com.xiao.beans.Car;
import com.xiao.config.MainConfigOfLifeCycle;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 13:48
 */
public class IOCTest_LifeCycle {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfLifeCycle.class);
        System.out.println("容器创建成功");
        Car car = (Car) context.getBean("car");
        //关闭容器
        context.close();
    }
}
