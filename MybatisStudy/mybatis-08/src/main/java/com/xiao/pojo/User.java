package com.xiao.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author simba@onlying.cn
 * @date 2021/5/18 16:41
 */
@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String pwd;
}
