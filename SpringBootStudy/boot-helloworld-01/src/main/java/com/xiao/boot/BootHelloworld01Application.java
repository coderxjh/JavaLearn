package com.xiao.boot;

import com.xiao.boot.bean.Pet;
import com.xiao.boot.bean.User;
import com.xiao.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BootHelloworld01Application {

    public static void main(String[] args) {
        //1.返回ioc容器
        ConfigurableApplicationContext run = SpringApplication.run(BootHelloworld01Application.class, args);
        //2.查看容器里面的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
        //3.从容器中获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println(tom01 == tom02);

        //4、com.xiao.boot.config.MyConfig$$EnhancerBySpringCGLIB$$8b52ddc@60921b21
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);

        //如果@Configuration(proxyBeanMethods = true)代理对象调用方法。SpringBoot总会检查这个组件是否在容器中
        //保持组件单实例
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println(user01==user02);

        User user011 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println(user011.getPet() == tom);
    }

}
