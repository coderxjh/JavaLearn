package com.xiao.aop;

/**
 * @author simba@onlying.cn
 * @date 2021/6/6 14:08
 */
public class MathCalculator {

    public int div(int i, int j) {
        System.out.println("MathCalculator.div()");
        return i / j;
    }
}
