package com.xiao.bootwebadmin.config;

/**
 * @author simba@onlying.cn
 * @date 2021/7/5 19:42
 */
//@Configuration
//public class MyDataSourceConfig {
//
//    //默认的自动配置是判断容器中没有才会配置@ConditionalOnMissingBean(DataSource.class)
//    @Bean
//    @ConfigurationProperties("spring.datasource")
//    public DataSource dataSource() throws SQLException {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        //加入监控功能
//        druidDataSource.setFilters("stat,wall");
//        return new DruidDataSource();
//    }
//
//    /**
//     * 配置druid的监控页功能
//     * @return
//     */
//    @Bean
//    public ServletRegistrationBean statViewServlet(){
//        StatViewServlet statViewServlet = new StatViewServlet();
//        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<>(statViewServlet, "/druid/*");
//        servletRegistrationBean.addInitParameter("loginUsername","root");
//        servletRegistrationBean.addInitParameter("loginPassword","123456");
//        return servletRegistrationBean;
//    }
//
//    /**
//     * WebStatFilter用于采集web-jdbc关联监控的数据。
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean webStatFilter(){
//        WebStatFilter webStatFilter=new WebStatFilter();
//        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
//        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
//        filterRegistrationBean.addInitParameter("exclusions","*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        return filterRegistrationBean;
//    }
//}