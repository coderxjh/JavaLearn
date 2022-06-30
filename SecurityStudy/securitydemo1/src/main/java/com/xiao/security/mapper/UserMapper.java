package com.xiao.security.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.security.entity.Users;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author xjh
 * @create 2022-03-12 15:15
 */
@Mapper
public interface UserMapper extends BaseMapper<Users> {

}
