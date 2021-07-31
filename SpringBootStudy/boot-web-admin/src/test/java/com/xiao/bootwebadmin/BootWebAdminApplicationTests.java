package com.xiao.bootwebadmin;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class BootWebAdminApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Test
    void contextLoads() {
//        jdbcTemplate.queryForList("select * from tb_car");
        Long aLong = jdbcTemplate.queryForObject("select count(*) from tb_car", Long.class);
        log.info("记录总数：{}",aLong);
        log.info("数据源类型：{}",dataSource.getClass());
    }

    @Test
    void testRedis(){
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("hello","world");
        String hello = valueOperations.get("hello");
        System.out.println(hello);
    }
}
