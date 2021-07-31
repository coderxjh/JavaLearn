package com.xiao.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.mp.pojo.Employee;

/**
 * Mapper接口：
 * 基于Mybatis：在Mapper接口中编写CRUD相关的方法，提供Mapper接口所对应的SQL映射文件以及方法对应的SQL语句
 * 基于MP：在XxxMapper接口继承BaseMapper接口即可
 * BaseMapper<T>:泛型指定的就是当前Mapper接口所操作的实体类类型
 *
 * @author simba@onlying.cn
 * @date 2021/5/19 21:40
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    /**
     * 支持主键自增的数据库插入数据获取主键值
     * Mybatis: 需要通过 useGeneratedKeys 以及 keyProperty 来设置
     *  <insert useGeneratedKeys="true" keyProperty="id">SQL...</insert>
     * MP: 自动将主键值回写到实体类中
     */
}