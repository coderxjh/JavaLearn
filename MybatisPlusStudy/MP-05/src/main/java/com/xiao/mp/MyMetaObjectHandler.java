package com.xiao.mp;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * 自定义公共字段填充处理器
 *
 * @author simba@onlying.cn
 * @date 2021/5/25 18:51
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入操作 自动填充
     *
     * @param metaObject
     */
    public void insertFill(MetaObject metaObject) {
        //获取到需要被填充的字段的值
        Object fieldValue = getFieldValByName("name", metaObject);
        if (fieldValue == null) {
            System.out.println("******插入操作 满足填充条件******");
            setFieldValByName("name", "weiyunhui", metaObject);
        }
    }

    /**
     * 修改操作 自动填充
     *
     * @param metaObject
     */
    public void updateFill(MetaObject metaObject) {
        //获取到需要被填充的字段的值
        Object fieldValue = getFieldValByName("name", metaObject);
        if (fieldValue == null) {
            System.out.println("******插入操作 满足填充条件******");
            setFieldValByName("name", "weiyh", metaObject);
        }
    }
}
