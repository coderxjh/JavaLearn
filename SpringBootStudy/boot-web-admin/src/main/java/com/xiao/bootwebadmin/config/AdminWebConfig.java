package com.xiao.bootwebadmin.config;

import com.xiao.bootwebadmin.interceptor.LoginInterceptor;
import com.xiao.bootwebadmin.interceptor.RedisUrlCountInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 1、编写一个拦截器实现HandlerInterceptor接口
 * 2、拦截器注册到容器中（实现WebMvcConfigurer的addInterceptors方法）
 * 3、指导拦截规则【如果是拦截所有，静态资源也会被拦截】
 * @author simba@onlying.cn
 * @date 2021/6/24 16:23
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

    /**
     * Filter、Interceptor 几乎拥有相同的功能
     * 1、Filter是Serlvet定义的原生组件。好处，脱离Spring应用也能使用
     * 2、Interceptor是Spring定义的接口。可以使用Spring的自动装配等功能
     */
//    @Autowired
    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //所有静态资源也被拦截
                .excludePathPatterns("/", "/login","/css/**","/fonts/**","/images/**","/js/**");
//        registry.addInterceptor(redisUrlCountInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/", "/login","/css/**","/fonts/**","/images/**","/js/**");
    }
}
