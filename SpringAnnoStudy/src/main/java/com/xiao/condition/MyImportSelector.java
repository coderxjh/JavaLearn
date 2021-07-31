package com.xiao.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义逻辑返回需要导入的组件
 *
 * @author simba@onlying.cn
 * @date 2021/5/30 19:38
 */
public class MyImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata 当前标注@Import注解的类的所有注解信息
     * @return 就是导入到容器中组件全类名
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        return new String[]{"com.xiao.beans.Yellow", "com.xiao.beans.Blue"};
    }
}
