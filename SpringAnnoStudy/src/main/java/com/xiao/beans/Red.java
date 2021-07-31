package com.xiao.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;

/**
 * @author simba@onlying.cn
 * @date 2021/5/30 19:35
 */
@Component
public class Red implements ApplicationContextAware, BeanNameAware, EmbeddedValueResolverAware, InitializingBean, DisposableBean {

    private ApplicationContext applicationContext;

    public Red() {
        System.out.println("无参构造器");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("传入的ioc:" + applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("当前bean的名字:" + name);
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        String value = resolver.resolveStringValue("你好${os.name} 我是#{20*18}");
        System.out.println("解析的字符串：" + value);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("red... destroy...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("red... afterPropertiesSet...");
    }

    @PostConstruct
    public void init() {
        System.out.println("red ... @PostConstruct...");
    }
}
