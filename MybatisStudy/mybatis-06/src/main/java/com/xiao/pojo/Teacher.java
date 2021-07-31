package com.xiao.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author simba@onlying.cn
 * @date 2021/5/17 17:15
 */
@Data
public class Teacher {

    private int id;
    private String name;
    private List<Student> students;
}
