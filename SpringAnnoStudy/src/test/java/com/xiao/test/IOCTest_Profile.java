package com.xiao.test;

import com.xiao.config.MainConfigOfProfile;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author simba@onlying.cn
 * @date 2021/5/31 13:48
 */
public class IOCTest_Profile {

    //1、使用命令行动态参数：在虚拟机参数位置加载-Dspring.profiles.active=test
    //2、代码方式激活
    @Test
    public void test01() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //1、创建一个applicationContext
        //2、设置需要激活的环境
        context.getEnvironment().setActiveProfiles("test");
        //3、注册主配置类
        context.register(MainConfigOfProfile.class);
        //4、启动刷新容器
        context.refresh();
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }
}
