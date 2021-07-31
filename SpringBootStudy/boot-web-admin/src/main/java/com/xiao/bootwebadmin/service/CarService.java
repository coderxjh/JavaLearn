package com.xiao.bootwebadmin.service;

import com.xiao.bootwebadmin.bean.Car;

/**
 * @author simba@onlying.cn
 * @date 2021/7/6 20:47
 */
public interface CarService {

    Car getCarById(Long id);

    void saveCar(Car car);
}
