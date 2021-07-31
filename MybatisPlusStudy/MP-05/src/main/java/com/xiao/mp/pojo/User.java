package com.xiao.mp.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @author simba@onlying.cn
 * @date 2021/5/24 19:44
 */
public class User {

    private Integer id;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String name;
//    @TableLogic //逻辑删除字段
    private Integer logicFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLogicFlag() {
        return logicFlag;
    }

    public void setLogicFlag(Integer logicFlag) {
        this.logicFlag = logicFlag;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logicFlag=" + logicFlag +
                '}';
    }
}
