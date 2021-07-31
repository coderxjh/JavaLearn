package com.xiao.test;

import com.xiao.beans.Person;
import com.xiao.config.MainConfigOfPropertyValues;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 13:48
 */
public class IOCTest_PropertyValue {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfigOfPropertyValues.class);

    @Test
    public void test01() {
        printBeans();
        System.out.println("===========");
        Person person = (Person) context.getBean("person");
        System.out.println(person);

        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("person.nickName");
        System.out.println(property);
        context.close();
    }

    /**
     * 输出打印容器中定义的组件
     */
    public void printBeans() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}
