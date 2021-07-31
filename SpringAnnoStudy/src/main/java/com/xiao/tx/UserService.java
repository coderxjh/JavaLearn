package com.xiao.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author simba@onlying.cn
 * @date 2021/6/6 15:41
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    public void insertUser() {
        System.out.println("插入完成");
        int i = 10 / 0;
    }
}
