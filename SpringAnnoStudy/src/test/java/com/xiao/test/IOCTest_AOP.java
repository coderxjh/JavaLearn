package com.xiao.test;

import com.xiao.aop.MathCalculator;
import com.xiao.config.MainConfigOfAOP;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 13:48
 */
public class IOCTest_AOP {

    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfAOP.class);
        //1、不要自己创建对象
//        MathCalculator mathCalculator = new MathCalculator();
////        mathCalculator.div(1,1);
        MathCalculator mathCalculator = context.getBean(MathCalculator.class);
        mathCalculator.div(1, 1);
        context.close();
    }
}
