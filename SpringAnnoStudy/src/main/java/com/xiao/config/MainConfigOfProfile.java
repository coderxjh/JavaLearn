package com.xiao.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xiao.beans.Yellow;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * Profile:
 * Spring为我们提供的可以根据当前环境，动态的激活和切换一系列组件的功能
 * <p>
 * 开发环境、测试环境、生产环境
 * 数据源：A、B、C
 *
 * @author simba@onlying.cn
 * @Profile: 指定组件在哪个环境的情况下才能被注册到容器中，不指定，在任何情况下都能注册这个组件
 * 1)、加了环境标识的bean，只有这个环境被激活的时候才能注册到容器中。默认是default环境
 * 2）、卸载配置类上，只有是指定的环境的时候，整个配置类里面的所有配置才能开始生效
 * 3）、没有标注环境标识的bean，在任何环境下都是加载的
 * @date 2021/6/5 19:46
 */
@PropertySource("classpath:dbconfig.properties")
public class MainConfigOfProfile {

    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.driver}")
    private String driver;

    @Bean
    public Yellow yellow() {
        return new Yellow();
    }

    @Profile("test")
    @Bean("testDataSource")
    public DataSource dataSourceTest() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test5?useSSL=false&serverTimeZone=UTC");
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDev() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/xiaomi?useSSL=false&serverTimeZone=UTC");
        dataSource.setDriverClass(driver);
        return dataSource;
    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/xjh?useSSL=false&serverTimeZone=UTC");
        return dataSource;
    }
}
