package com.xiao.dao;

import org.springframework.stereotype.Repository;

/**
 * @author simba@onlying.cn
 * @date 2021/5/30 14:48
 */
@Repository
public class BookDao {

    private String lable = "1";

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    @Override
    public String toString() {
        return "BookDao{" +
                "lable='" + lable + '\'' +
                '}';
    }
}
