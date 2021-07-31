package com.xiao.mp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author simba@onlying.cn
 * @date 2021/5/19 19:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Model<Employee> implements Serializable {

    private static final long serialVersionUID = 5005032889086220068L;
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false)
    private Double salary;
}