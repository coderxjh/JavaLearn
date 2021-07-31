package com.xiao.boot.config;

import ch.qos.logback.core.db.DBHelper;
import com.xiao.boot.bean.Car;
import com.xiao.boot.bean.Pet;
import com.xiao.boot.bean.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods:代理bean的方法
 *      Full(proxyBeanMethods = true)
 *      Lite(proxyBeanMethods = false)
 *      组件依赖
 *
 * 4、@Import({User.class,DBHelper.class})
 *      给容器中自动创建这两个类型的组件，默认组件的名字就是全类名
 *
 * 5、@ImportResource("classpath:beans.xml")导入Spring的配置文件
 *
 * @author simba@onlying.cn
 * @date 2021/6/13 17:17
 */
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = true)//告诉SpringBoot这是一个配置类==配置文件
@EnableConfigurationProperties(Car.class)
//1、开启Car属性配置功能
//2、把Car这个组件自动注册到容器中
public class MyConfig {

    /**
     * proxyBeanMethods = true：外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例对象
     * @return
     */
    @Bean//给容器中添加组件。以方法名作为组件的id。返回类型就是组件类型。返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan", 18);
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}