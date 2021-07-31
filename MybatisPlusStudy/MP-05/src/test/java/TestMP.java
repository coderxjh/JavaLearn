import com.xiao.mp.config.SpringConfig;
import com.xiao.mp.mapper.EmployeeMapper;
import com.xiao.mp.mapper.UserMapper;
import com.xiao.mp.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author simba@onlying.cn
 * @date 2021/5/24 17:57
 */
public class TestMP {

    private ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);

    private EmployeeMapper employeeMapper = ioc.getBean(EmployeeMapper.class);

    private UserMapper userMapper = ioc.getBean(UserMapper.class);

    /**
     * 测试自定义全局操作
     */
    @Test
    public void testMySqlInjector() {
        Integer result = employeeMapper.deleteAll();
        System.out.println(result);
    }

    /**
     * 测试逻辑删除
     */
    @Test
    public void testLogicDelete() {
//        int result = userMapper.deleteById(1);
//        System.out.println(result);
        User user = userMapper.selectById(1);
        System.out.println(user);
    }


    /**
     * 测试公共字段自动填充
     */
    @Test
    public void testMetaObjectHandler() {
        User user = new User();
        user.setLogicFlag(1);
        user.setId(6);
        userMapper.updateById(user);
    }
}