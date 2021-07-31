import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xiao.mp.config.SpringConfig;
import com.xiao.mp.pojo.Employee;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author simba@onlying.cn
 * @date 2021/5/21 17:36
 */
public class TestMP {

    private ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);

    /**
     * AR 插入操作
     */
    @Test
    public void testARInsert() {
        Employee employee = new Employee();
        employee.setLastName("宋老师");
        employee.setEmail("sls@atguigu.com");
        employee.setGender(1);
        employee.setAge(35);
        boolean insert = employee.insert();
        System.out.println(insert);
    }

    /**
     * AR 修改操作
     */
    @Test
    public void testARUpdate() {
        Employee employee = new Employee();
        employee.setId(21);
        employee.setLastName("宋老师");
        employee.setEmail("sls@atguigu.com");
        employee.setGender(0);
        employee.setAge(36);
        boolean update = employee.insertOrUpdate();
        System.out.println(update);
    }

    /**
     * AR 查询操作
     */
    @Test
    public void testARSelect() {
        Employee employee = new Employee();
        employee.setId(2);
        Employee result = employee.selectById();
        System.out.println(result);
        List<Employee> employees = employee.selectList(new QueryWrapper<Employee>().like("last_name", "假面"));
        System.out.println(employees);
        Integer count = employee.selectCount(new QueryWrapper<Employee>().eq("gender", 0));
        System.out.println("总数：" + count);
    }

    /**
     * AR 删除操作
     */
    @Test
    public void testARDelete() {
        Employee employee = new Employee();
        boolean result = employee.deleteById(1);
        System.out.println(result);
    }

    /**
     * AR 分页复杂操作
     */
    @Test
    public void testARPage(){
        Employee employee = new Employee();
        Page<Employee> employeePage = employee.selectPage(new Page<Employee>(1, 2), null);
        List<Employee> employees = employeePage.getRecords();
        System.out.println(employees);
    }
}
