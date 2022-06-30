package com.xiao.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author xjh
 * @create 2022-03-12 14:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Users {
    private Integer id;
    private String username;
    private String password;
}
