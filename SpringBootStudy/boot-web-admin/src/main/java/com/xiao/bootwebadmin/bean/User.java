package com.xiao.bootwebadmin.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author simba@onlying.cn
 * @date 2021/6/24 15:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("user")
public class User {

    /**
     * 所以属性都应该在数据库中
     */
    @TableField(exist = false)
    private String userName;
    @TableField(exist = false)
    private String passWord;


    private Long id;
    private String name;
    private Integer age;
    private String email;
}