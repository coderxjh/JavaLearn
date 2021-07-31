package com.xiao.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * @author simba@onlying.cn
 * @date 2021/5/18 15:03
 */
public class IDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(IDUtils.getId());
    }
}