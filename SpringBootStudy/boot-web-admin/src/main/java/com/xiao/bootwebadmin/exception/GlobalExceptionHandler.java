package com.xiao.bootwebadmin.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web controller的异常
 * @author simba@onlying.cn
 * @date 2021/7/9 20:40
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})//需要处理的异常
    public String handleArithException(Exception e){
        log.info("异常是：{}",e);
        return "login"; //视图地址
    }

}
