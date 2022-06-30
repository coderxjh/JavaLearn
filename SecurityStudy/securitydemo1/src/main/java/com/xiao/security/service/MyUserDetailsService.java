package com.xiao.security.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xiao.security.entity.Users;
import com.xiao.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xjh
 * @create 2022-03-12 11:34
 */
@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //调用usersMapper方法，根据用户名查询数据库
        QueryWrapper<Users> queryWrapper = new QueryWrapper<>();
        //where username=?
        queryWrapper.eq("username", username);
        Users users = userMapper.selectOne(queryWrapper);
        //判断
        if (users == null) {
            throw new UsernameNotFoundException("用户名不存在!");
        }
        List<GrantedAuthority> auths = AuthorityUtils.commaSeparatedStringToAuthorityList("admins,ROLE_sale");
        //从查询数据库返回users对象，得到用户名和密码，返回
        return new User(users.getUsername(), new BCryptPasswordEncoder().encode(users.getPassword()), auths);
    }
}