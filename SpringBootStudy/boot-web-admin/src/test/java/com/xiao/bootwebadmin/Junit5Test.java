package com.xiao.bootwebadmin;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

/**
 * Junit5相关测试：断言机制、前置条件
 * @author simba@onlying.cn
 * @date 2021/7/7 16:09
 */
@DisplayName("junit5功能测试类")
@SpringBootTest
public class Junit5Test {

    @Test
    @DisplayName("测试前置条件")
    void testAssumptions(){
        assumeTrue(false,"结果不是true");
        System.out.println("11111");

    }


    /**
     * 断言：前面断言失败，后面的代码都不会执行
     */
    @DisplayName("简单断言")
    @Test
    void testSimpleAssertions() {
        int cal = cal(3, 2);
        //判断相等
        assertEquals(5, cal, "业务逻辑计算失败");
        Object o = new Object();
        Object o1 = new Object();
        assertSame(o, o1, "两个对象不一样");
    }

    @Test
    @DisplayName("数组断言")
    void testArrayAssertions() {
        assertArrayEquals(new int[]{2, 1}, new int[]{1, 2}, "数组内容不相等");
    }

    @Test
    @DisplayName("组合断言")
    void testAllAssertions() {
        /**
         * 所有断言全部需要成功
         */
        assertAll("test",
                () -> assertTrue(true && true, "结果不为true"),
                () -> assertEquals(1, 2, "结果不是1"));
        System.out.println("=======");
    }

    @DisplayName("异常断言")
    @Test
    void testExceptionAssertions() {
        //断定业务逻辑一定出现异常，没有出现异常就会报错
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 0;
        }, "业务逻辑居然正常执行");
    }

    @Test
    @DisplayName("快速失败")
    void testFail() {
        fail("测试失败");
    }

    int cal(int i, int j) {
        return i + j;
    }

    @DisplayName("测试DisplayName注解")
    @Test
    void testDisplayName() {
        System.out.println(1);
    }

    @Disabled
    @DisplayName("测试方法2")
    @Test
    void test2() {
        System.out.println(2);
    }

    @RepeatedTest(5)
    void test3() {
        System.out.println(5);
    }

    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    @Test
    void testTimeOut() throws InterruptedException {
        Thread.sleep(600);
    }

    @BeforeEach
    void testBeforeEach() {
        System.out.println("测试就要开始了");
    }

    @AfterEach
    void testAfterEach() {
        System.out.println("测试就要结束了");
    }

    @BeforeAll
    static void testBeforeAll() {
        System.out.println("所有测试就要开始了");
    }

    @AfterAll
    static void testAfterAll() {
        System.out.println("所有测试已经结束了");
    }
}