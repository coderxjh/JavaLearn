package com.xiao.mp.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Mybatisplus会默认使用实体类的类名到数据库中找对应的表
 * @author simba@onlying.cn
 * @date 2021/5/19 19:51
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("tbl_employee")
public class Employee {

    /**
     * @TableId:
     *      value:指定表中主键列的列名，如果实体属性名与列名一致，可以省略
     *      type：指定主键策略
     *      在GlobalConfig这个全局配置类中设置了IdType时，可省略
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField("last_name")
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

    @TableField(exist = false)
    private Double salary;
}