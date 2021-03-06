package com.xiao.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 19:30
 */
//默认加载ioc容器中的组件，容器启动会调用无参构造器创建对象，再进行初始化赋值等操作
@Component
public class Boss {

    private Car car;

    public Boss() {
        System.out.println("调用无参构造器方法");
    }

    //构造器要用的组件，都是容器中获取的
    public Boss(Car car) {
        System.out.println("调用有参构造器方法");
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    @Autowired
    //标注在方法，Spring容器创建当前对象，就会调用方法，完成赋值；
    //方法使用的参数，自定义类型的值从ioc容器中获取
    public void setCar(Car car) {
        System.out.println("调用set方法");
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}