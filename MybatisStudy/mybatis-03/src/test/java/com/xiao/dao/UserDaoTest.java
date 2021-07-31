package com.xiao.dao;

import com.xiao.pojo.User;
import com.xiao.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author simba@onlying.cn
 * @date 2021/5/16 14:51
 */
public class UserDaoTest {

    @Test
    public void getUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = mapper.getUserById(3);
        System.out.println(user);
        sqlSession.close();
    }
}