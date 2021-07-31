package com.xiao.dao;


import com.xiao.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserById(int id);

}