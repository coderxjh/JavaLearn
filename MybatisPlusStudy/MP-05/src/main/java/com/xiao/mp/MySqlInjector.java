package com.xiao.mp;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.xiao.mp.methods.DeleteAll;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 自定义Sql注入
 * @author simba@onlying.cn
 * @date 2021/5/24 17:16
 */
@Component
public class MySqlInjector extends DefaultSqlInjector {

    @Override
    public List<AbstractMethod> getMethodList(Class<?> mapperClass) {
        List<AbstractMethod> methodList = super.getMethodList(mapperClass);
        //增加自定义的方法
        methodList.add(new DeleteAll());
        return methodList;
    }
}
