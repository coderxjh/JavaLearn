package com.xiao.bootwebadmin.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = {"/css/*", "/images/*"})
public class MyFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        log.info("MyFilter初始化完成");
    }

    public void destroy() {
        log.info("MyFilter销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        log.info("MyFilter工作");
        chain.doFilter(request, response);
    }
}