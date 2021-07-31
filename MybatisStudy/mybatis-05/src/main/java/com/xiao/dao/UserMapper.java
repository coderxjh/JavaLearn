package com.xiao.dao;


import com.xiao.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有的参数签名必须加上 @Param()注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert user(id,name,pwd) values(#{id},#{name},#{password})")
    void addUser(User user);

    @Delete("delete from user where id = #{uid}")
    void deleteUser(@Param("uid") int id);

    @Update("update user set name = #{name},pwd=#{password} where id #{id}")
    void updateUser(User user);
}