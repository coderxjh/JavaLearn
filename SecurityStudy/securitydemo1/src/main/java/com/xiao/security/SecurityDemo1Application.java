package com.xiao.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * @author xjh
 * @create 2022-03-10 8:45
 */
@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemo1Application.class);
    }
}