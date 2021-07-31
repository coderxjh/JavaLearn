package com.xiao.aop;



import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * @author simba@onlying.cn
 * @Aspect: 告诉Spring当前类是一个切面类
 * @date 2021/6/6 14:10
 */
@Aspect
public class LogAspects {

    //抽取公共的切入点表达式
    //1、本类引用：pointCut()
    //2、其他的切面引用：com.xiao.aop.LogAspects.pointCut()
    @Pointcut("execution(* com.xiao.aop.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println("" + joinPoint.getSignature().getName() + "运行。。。参数列表是:" + Arrays.asList(args));
    }

    //JoinPoint一定要出现在参数表的第一位
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        System.out.println(joinPoint.getSignature().getName() + "正常返回。。。运行结果:" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logException(JoinPoint joinPoint, Exception exception) {
        System.out.println(joinPoint.getSignature().getName() + "异常。。。异常信息:{" + exception.toString() + "}");
    }

    @After("com.xiao.aop.LogAspects.pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "结束。。。");
    }
}