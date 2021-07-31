package com.xiao.boot.bean;

/**
 * @author simba@onlying.cn
 * @date 2021/6/13 17:14
 */
public class Pet {

    private String name;

    public Pet() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}