package com.xiao.pojo;

import lombok.Data;

/**
 * @author simba@onlying.cn
 * @date 2021/5/17 17:15
 */
@Data
public class Student {

    private Integer id;
    private String name;
    private int tid;
    private Teacher teacher;
}
