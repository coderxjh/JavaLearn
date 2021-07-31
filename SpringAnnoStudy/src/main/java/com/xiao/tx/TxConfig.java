package com.xiao.tx;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 声明式事务：
 * <p>
 * 环境搭建：
 * 1、导入相关依赖
 * 数据源、数据库驱动、Spring-jdbc模块
 * 2、配置数据源、jdbcTemplate(Spring提供的简化数据库操作的工具)操作数据
 * 3、给方法上标注@Transactional表示当前方法是一个事务方法
 * 4、@EnableTransactionManagement 开启基于注解的事务管理功能
 * 5、配置事务管理器来控制事务
 * <p>
 * 声明式事务原理：
 * 1）、
 *
 * @author simba@onlying.cn
 * @date 2021/6/6 15:38
 */
@EnableTransactionManagement
@Configuration
@ComponentScan("com.xiao.tx")
public class TxConfig {

    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test6?useSSL=false&serverTimeZone=UTC");
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring对@Configuration类会特殊处理，给容器中加组件的方法，多次调用都只是从容器中找组件
        return new JdbcTemplate(dataSource());
    }

    //注册事务管理器在容器中
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
