package com.xiao.beans;

/**
 * @author simba@onlying.cn
 * @date 2021/5/30 19:23
 */
public class Color {

    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Color{" +
                "car=" + car +
                '}';
    }
}