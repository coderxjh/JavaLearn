package com.xiao.test;

import com.xiao.beans.Boss;
import com.xiao.beans.Car;
import com.xiao.beans.Color;
import com.xiao.config.MainConfigOfAutowired;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 13:48
 */
public class IOCTest_Autowired {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAutowired.class);

    @Test
    public void test01() {
//        BookService bookService = context.getBean(BookService.class);
//        System.out.println(bookService);
//        BookDao bookDao = (BookDao) context.getBean(BookDao.class);
//        System.out.println(bookDao);
        Boss boss = (Boss) context.getBean(Boss.class);
        System.out.println(boss);
        Car car = context.getBean(Car.class);
        System.out.println(car);
        Color color = context.getBean(Color.class);
        System.out.println(color);
        System.out.println(context);
        context.close();
    }
}