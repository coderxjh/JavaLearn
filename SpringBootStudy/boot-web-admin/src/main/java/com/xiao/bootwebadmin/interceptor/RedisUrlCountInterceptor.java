package com.xiao.bootwebadmin.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author simba@onlying.cn
 * @date 2021/7/7 0:12
 */
//@Component
@Slf4j
public class RedisUrlCountInterceptor implements HandlerInterceptor {

//    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        //默认每次访问当前uri就会计数+1
        stringRedisTemplate.opsForValue().increment(uri);
        return true;
    }
}
