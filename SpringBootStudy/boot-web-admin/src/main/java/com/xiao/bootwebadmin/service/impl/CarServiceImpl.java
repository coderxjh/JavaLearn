package com.xiao.bootwebadmin.service.impl;

import com.xiao.bootwebadmin.bean.Car;
import com.xiao.bootwebadmin.mapper.CarMapper;
import com.xiao.bootwebadmin.service.CarService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author simba@onlying.cn
 * @date 2021/7/6 18:31
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarMapper carMapper;
    Counter counter;

    public CarServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("carService.getCar.count");
    }

    public Car getCarById(Long id){
        counter.increment();
        return carMapper.getCarById(id);
    }

    @Override
    public void saveCar(Car car) {
        carMapper.insert(car);
    }
}