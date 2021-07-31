package com.xiao.bootwebadmin.bean;

/**
 * @author simba@onlying.cn
 * @date 2021/7/6 18:22
 */
public class Car {

    private String carId;
    private String carName;
    private String carMethod;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarMethod() {
        return carMethod;
    }

    public void setCarMethod(String carMethod) {
        this.carMethod = carMethod;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", carName='" + carName + '\'' +
                ", carMethod='" + carMethod + '\'' +
                '}';
    }
}
