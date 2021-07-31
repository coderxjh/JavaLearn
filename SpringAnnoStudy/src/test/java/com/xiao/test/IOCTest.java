package com.xiao.test;

import com.xiao.beans.Person;
import com.xiao.config.MainConfig;
import com.xiao.config.MainConfig2;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Arrays;
import java.util.Map;

/**
 * @author simba@onlying.cn
 * @date 2021/5/30 14:40
 */
public class IOCTest {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig2.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = context.getBean(Person.class);
        System.out.println(person);
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }

    /**
     * 测试配置类1
     */
    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] beanDefinitionNames = context.getBeanDefinitionNames();//获取容器中定义的组件的id
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }

    /**
     * 测试配置类2
     *
     * @Scope注解 singleton：单例
     * prototype：多例
     * 懒加载
     */
    @Test
    public void test02() {
        System.out.println("ioc容器创建完成");
        Object person1 = context.getBean("person");
        Object person2 = context.getBean("person");
//        System.out.println(person1.equals(person2));
    }

    /**
     * 测试按条件给容器注入组件
     *
     * @Conditional注解
     */
    @Test
    public void test03() {
        String[] beanNamesForType = context.getBeanNamesForType(Person.class);
        Arrays.stream(beanNamesForType).forEach(System.out::println);
        ConfigurableEnvironment environment = context.getEnvironment();
        String property = environment.getProperty("os.name");
        System.out.println(property);
        Map<String, Person> beansOfType = context.getBeansOfType(Person.class);
        System.out.println(beansOfType);
    }

    /**
     * 测试@Import注解
     */
    @Test
    public void testImport() {
        printBeans();

        //通过id获取工厂Bean的时候是调用getObject创建的对象
        Object colorFactoryBean = context.getBean("colorFactoryBean");
        Object colorFactoryBean2 = context.getBean("colorFactoryBean");
        System.out.println("bean的类型:" + colorFactoryBean.getClass());
        System.out.println(colorFactoryBean == colorFactoryBean2);

        Object bean = context.getBean("&colorFactoryBean");
        System.out.println(bean.getClass());
    }

    /**
     * 输出打印容器中定义的组件
     */
    public void printBeans() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
    }
}