package com.xiao.mp.methods;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 *
 * @author simba@onlying.cn
 * @date 2021/5/24 17:46
 */
public class DeleteAll extends AbstractMethod {

    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        //将EmployeeMapper中定义的deleteAll，处理成对应的MappedStatement对象，加入到configuration对象中
        //注入的SQL语句
        String sql = "delete from " + tableInfo.getTableName();
        //注入的方法名，一定要与EmployeeMapper接口中的方法名一致
        String method = "deleteAll";
        //构造SqlSource对象
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addDeleteMappedStatement(mapperClass, method, sqlSource);
    }
}