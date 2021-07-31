package com.xiao.bootwebadmin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiao.bootwebadmin.bean.User;
import com.xiao.bootwebadmin.mapper.UserMapper;
import com.xiao.bootwebadmin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author simba@onlying.cn
 * @date 2021/7/6 20:46
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
