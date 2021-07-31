package com.xiao.dao;


import com.xiao.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserLike(String name);

    List<User> getUserList();

    List<User> getUserById(int id);

    List<User> getUserById2(Map<String, Object> map);

    int addUser(User user);

    int addUser2(Map<String, Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}