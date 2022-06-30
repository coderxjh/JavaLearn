package com.xiao.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author xjh
 * @create 2022-03-12 11:30
 */
@Configuration
public class SecurityConfigTest extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    //注入数据源
    @Autowired
    private DataSource dataSource;

    //配置操纵数据库对象
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepository = new JdbcTokenRepositoryImpl();
        jdbcTokenRepository.setDataSource(dataSource);
        return jdbcTokenRepository;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //退出
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login.html");
        //配置没有权限访问跳转自定义页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        //自定义自己编写的登录页面
        http.formLogin()
                .loginPage("/login.html").permitAll()   //登录页面设置
                .loginProcessingUrl("/user/login")  //登录访问路径
                .defaultSuccessUrl("/success.html");  //登录成功之后，跳转路径
        http.authorizeRequests()
                .antMatchers("/", "/test/hello", "/user/login").permitAll() //设置哪些路径可以直接访问，不需要认证
                //当前登录用户，只有用户具有admins权限才可以访问这个路径
                //.antMatchers("/test/index").hasAuthority("admins,manager")
                //当前登录用户，只有用户具有admins或者manager权限才可以访问这个路径
                //.antMatchers("/test/index").hasAnyAuthority("admins", "manager")
                .antMatchers("/test/index").hasRole("sale")
                .anyRequest()// 其他请求
                .authenticated();//需要认证
        //关闭csrf服务
        http.csrf().disable();
        //设置自动登录
        http.rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60)
                .userDetailsService(userDetailsService);
    }

    @Bean
    PasswordEncoder password() {
        return new BCryptPasswordEncoder();
    }
}