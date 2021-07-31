package com.xiao.bootwebadmin.mapper;

import com.xiao.bootwebadmin.bean.Car;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CarMapper {

    Car getCarById(Long id);

    void insert(Car car);
}
