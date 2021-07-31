package com.xiao.bootwebadmin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author simba@onlying.cn
 * @date 2021/7/9 20:49
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "用户数量太多")
public class UserTooManyException extends RuntimeException{


    public UserTooManyException() {
    }

    public UserTooManyException(String message){
        super(message);
    }
}
