package com.xiao.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiao.mp.pojo.Employee;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 肖江辉
 * @since 2021-05-21
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
    Integer deleteAll();
}
