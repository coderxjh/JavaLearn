package com.xiao.condition;

import com.xiao.beans.RainBow;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author simba@onlying.cn
 * @date 2021/5/30 19:50
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    /**
     * @param importingClassMetadata:当前类的注解信息
     * @param registry：BeanDefinition注册类；     把所有需要添加到容器中的bean
     *                                        调用BeanDefinitionRegistry.registerBeanDefinition手动注册进来
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        boolean red = registry.containsBeanDefinition("com.xiao.beans.Red");
        boolean blue = registry.containsBeanDefinition("com.xiao.beans.Blue");
        if (red && blue) {
            //指定Bean定义信息
            RootBeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            //注册一个bean，并指定bean的名字
            registry.registerBeanDefinition("rainbow", beanDefinition);
        }
    }
}
