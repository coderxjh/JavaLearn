package com.xiao.config;

import com.xiao.aop.LogAspects;
import com.xiao.aop.MathCalculator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP:【动态代理】
 * 指在程序运行期间动态的将某段代码切入到指定方法指定位置进行运行的编程方式
 * <p>
 * 1、导入aop模块；Spring AOP：(spring-aspects)
 * 2、定义一个业务逻辑类(MathCalculator)：在业务逻辑运行的时候将日志进行打印（方法之前、方法运行结束、方法出现异常）
 * 3、定义一个日志切面类(LogAspects)：切面类里面的方法需要动态感知MathCalculator.div运行到哪里然后执行
 * 通知方法：
 * 前置通知(@Before)：logStart：在目标方法(div)运行之前运行
 * 最终通知(@After)：logEnd：在目标方法(div)运行结束之后运行
 * 后置通知(@AfterReturning)：logReturn：在目标方法(div)正常返回之后运行
 * 异常通知(@AfterThrowing)：logException：在目标方法(div)出现异常之后运行
 * 环绕通知(@Around)：动态代理：手动推进目标方法运行（joinPoint.procced()）
 * 4、在切面类的目标方法标注何时何地运行（通知注解）；
 * 5、将切面类和业务逻辑类（目标方法所在类）都加入到容器中；
 * 6、必须告诉Spring哪个类是切面类（给切面类加上注解：@Aspect）
 * 7、给配置类中加@EnableAspectJAutoProxy【开启基于注解的aop模式】
 * <p>
 * 三步：
 * 1）、将业务逻辑组件和切面类都加入到容器中，告诉Spring哪个是切面类(@Aspect)
 * 2）、在切面类上的每一个通知方法标注通知注解，告诉Spring何时何地运行(切入到表达式)
 * 3）、开启基于注解的aop模式；@EnableAspectJAutoProxy
 *
 * @author simba@onlying.cn
 * @date 2021/6/6 14:04
 */
@Configuration
@EnableAspectJAutoProxy
public class MainConfigOfAOP {

    //业务逻辑类加入到容器中
    @Bean
    public MathCalculator mathCalculator() {
        return new MathCalculator();
    }

    //切面类加入到容器中
    @Bean
    public LogAspects logAspects() {
        return new LogAspects();
    }
}
