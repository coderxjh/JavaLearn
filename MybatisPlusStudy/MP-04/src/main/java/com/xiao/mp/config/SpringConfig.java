package com.xiao.mp.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.BlockAttackInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @author simba@onlying.cn
 * @date 2021/5/19 21:02
 */
@Configuration
@PropertySource("classpath:db.properties")
//基于注解的事务管理
@EnableTransactionManagement
//扫描所有mapper接口的实现，让这些mapper能够自动注入
@MapperScan(basePackages = "com.xiao.mp.mapper")
public class SpringConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 事务管理器
     *
     * @param dataSource
     * @return
     */
    @Bean("transactionManager")
    public DataSourceTransactionManager createTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * 数据源
     *
     * @return
     * @throws PropertyVetoException
     */
    @Bean("dataSource")
    public DataSource createDatasource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        //设置数据库驱动
        dataSource.setDriverClass(driver);
        //设置url
        dataSource.setJdbcUrl(url);
        dataSource.setPassword(password);
        dataSource.setUser(username);
        return dataSource;
    }

    @Bean("sqlSessionFactory")
    public SqlSessionFactory createSqlSessionFactory(DataSource dataSource,
                                                     GlobalConfig globalConfig,
                                                     MybatisConfiguration configuration,
                                                     MybatisPlusInterceptor interceptor) throws Exception {
        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        //注入数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //指定mybatis全局配置文件的路径
//        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        //指定mapper.xml文件的位置
//        sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("mappers/*.xml"));
        //别名设置
        sqlSessionFactoryBean.setTypeAliasesPackage("com.xiao.mp.pojo");
        //注入MyBatis-Plus的全局策略配置
        sqlSessionFactoryBean.setGlobalConfig(globalConfig);
        //注入MyBatis的全局配置
        sqlSessionFactoryBean.setConfiguration(configuration);

        sqlSessionFactoryBean.setPlugins(interceptor);
        return sqlSessionFactoryBean.getObject();
    }

    /**
     * MyBatis-Plus的全局策略配置类
     *
     * @param dbConfig
     * @return
     */
    @Bean("globalConfig")
    public GlobalConfig createGlobalConfig(GlobalConfig.DbConfig dbConfig) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setDbConfig(dbConfig);
        return globalConfig;
    }

    @Bean("dbConfig")
    public GlobalConfig.DbConfig createDbConfig() {
        GlobalConfig.DbConfig dbConfig = new GlobalConfig.DbConfig();
        //全局的主键策略配置
        dbConfig.setIdType(IdType.AUTO);
        //全局的表名前缀策略配置
        dbConfig.setTablePrefix("tbl_");
        return dbConfig;
    }

    @Bean("configuration")
    public MybatisConfiguration configuration() {
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setLogImpl(StdOutImpl.class);
        return configuration;
    }

    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        //注册分页插件
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
        //注册阻止恶意的全表更新删除插件
        interceptor.addInnerInterceptor(new BlockAttackInnerInterceptor());
        //注册乐观锁插件
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
        return interceptor;
    }
}