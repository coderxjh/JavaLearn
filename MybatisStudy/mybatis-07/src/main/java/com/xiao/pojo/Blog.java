package com.xiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author simba@onlying.cn
 * @date 2021/5/18 14:56
 */
@Data
@AllArgsConstructor
public class Blog {

    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}