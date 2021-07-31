package com.xiao.mp.service.impl;

import com.xiao.mp.pojo.Employee;
import com.xiao.mp.mapper.EmployeeMapper;
import com.xiao.mp.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 肖江辉
 * @since 2021-05-21
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    /**
     * EmployeeServiceImpl  继承了ServiceImpl
     * 1.在ServiceImpl中已经完成Mapper对象的注入，直接在EmployeeServiceImpl中进行使用
     * 2.在ServiceImpl中也帮我们提供了常用的CRUD方法，基本的一些CRUD方法在Service中不需要我们自己定义
     */
}
