import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.mp.config.SpringConfig;
import com.xiao.mp.mapper.EmployeeMapper;
import com.xiao.mp.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author simba@onlying.cn
 * @date 2021/5/22 22:08
 */
public class TestMP {

    private ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
    EmployeeMapper employeeMapper = ioc.getBean(EmployeeMapper.class);

    /**
     * 测试分页插件
     */
    @Test
    public void testPage() {
        Page<Employee> page = employeeMapper.selectPage(new Page<>(1, 2, true), null);
        System.out.println("总页数：" + page.getPages());
        System.out.println("总记录数：" + page.getTotal());
        System.out.println("一页显示几条：" + page.getSize());
        List<Employee> employees = page.getRecords();
        employees.forEach(System.out::println);
    }

    /**
     * 测试阻止恶意的全表更新删除插件
     */
    @Test
    public void testSQLExplain() {
        employeeMapper.delete(null);//全表删除
    }

    /**
     * 测试性能分析插件
     */
    @Test
    public void testPerformance(){
        Employee employee = new Employee();
        employee.setLastName("小泽老师");
        employee.setEmail("xz@atguigu.com");
        employee.setGender("0");
        employee.setAge(22);
        employeeMapper.insert(employee);
    }

    /**
     * 测试乐观锁操作
     */
    @Test
    public void testOptimisticLocker(){
        Employee employee=new Employee();
        employee.setId(2);
        employee.setLastName("Tom");
        employee.setEmail("tom@atguigu.com");
        employee.setGender("1");
        employee.setAge(22);
        employee.setVersion(2);
        employeeMapper.updateById(employee);
    }
}