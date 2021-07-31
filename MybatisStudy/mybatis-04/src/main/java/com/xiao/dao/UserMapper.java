package com.xiao.dao;

import com.xiao.pojo.User;

import java.util.List;

public interface UserMapper {

    List<User> getUserById(int id);

    List<User> getUserByLimit(int a, int b);
}