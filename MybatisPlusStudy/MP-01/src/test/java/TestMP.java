import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
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
 * @date 2021/5/20 15:46
 */
public class TestMP {

    private ApplicationContext ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
    private EmployeeMapper employeeMapper = ioc.getBean("employeeMapper", EmployeeMapper.class);

    /**
     * 通用插入操作
     */
    @Test
    public void testCommonInsert() {
        //初始化Employee对象
        Employee employee = new Employee();
        employee.setLastName("MP");
        employee.setEmail("mp@atguigu.com");
//        employee.setGender(1);
//        employee.setAge(22);
        //插入数据库
        //insert方法在插入时，会根据实体类的每个属性进行非空判断，只有非空的才会出现到SQL语句中
//        int result = employeeMapper.insert(employee);
        //insertAllColumn方法在插入时，不管属性是否非空，属性所对应的字段都会出现到SQL语句中
        employeeMapper.insert(employee);
        Integer id = employee.getId();
        System.out.println("主键值：" + id);
    }

    /**
     * 通用更新操作
     */
    @Test
    public void testCommonUpdate() {
        //初始化Employee对象
        Employee employee = new Employee();
        employee.setId(5);
        employee.setLastName("MybatisPlus");
        employee.setEmail("mybatisPlus@sina.com");
//        employee.setGender(0);
        employee.setAge(30);
        employeeMapper.updateById(employee);
    }

    /**
     * 通用查询操作
     */
    @Test
    public void testCommonSelect() {
        //1.通过id查询
//        Employee employee = employeeMapper.selectById(2);
        //2.通过多个列查询
//        Employee employee = new Employee();
//        employee.setId(2);
//        employee.setLastName("Tom");
//        employeeMapper.selectOne(employee);
        //3.通过多个id进行查询
//        List<Integer> idList=new ArrayList<>();
//        idList.add(1);
//        idList.add(2);
//        idList.add(4);
//        idList.add(5);
//        List<Employee> employees = employeeMapper.selectBatchIds(idList);
        //4.通过Map封装条件查询
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("last_name", "Tom");
//        columnMap.put("gender", 1);
//        List<Employee> employees = employeeMapper.selectByMap(columnMap);
//        employees.forEach(System.out::println);
        //5.分页查询
        Page<Employee> page = new Page<>(1, 2);
        employeeMapper.selectPage(page, null);
        List<Employee> records = page.getRecords();
        System.out.println(records);
    }

    /**
     * 通用删除操作
     */
    @Test
    public void testCommonDelete() {
        //1.通过id删除
        int result = employeeMapper.deleteById(17);
        //2.通过条件删除
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("last_name", "MP");
//        columnMap.put("email", "mp@atguigu.com");
//        employeeMapper.deleteByMap(columnMap);
        //3.批量删除
//        List<Integer> idList = new ArrayList<>();
//        idList.add(18);
//        idList.add(19);
//        idList.add(20);
//        employeeMapper.deleteBatchIds(idList);
    }

    /**
     * 条件构造器查询操作
     */
    @Test
    public void testQueryWrapperSelect() {
        //1.我们需要分页查询tbl_employee表中，年龄在18~50中间的且性别为男的Tom用户
//        Page<Employee> page = employeeMapper.selectPage(new Page<>(1, 2),
//                new QueryWrapper<Employee>()
//                        .eq("gender", 1)
//                        .eq("last_name", "Tom")
//                        .between("age", 18, 50));
//        List<Employee> records = page.getRecords();
//        records.forEach(System.out::println);

        //2.查询tbl_employee表中，性别为女，且名字中带有“老师”或者邮箱带有"a"
//        List<Employee> employees = employeeMapper.selectList(
//                new QueryWrapper<Employee>()
//                        .eq("gender", 1)
//                        .like("last_name", "奥特曼")
//                        .or()   //SQL:(gender = ? AND last_name like ? or email like ?)
////                        .or(employeeQueryWrapper -> employeeQueryWrapper)
//                        .like("email", "a")
//        );
//        employees.forEach(System.out::println);

        //查询性别为女，根据age进行排序(asc/desc),简单分页
        List<Employee> employees = employeeMapper.selectList(new QueryWrapper<Employee>()
                .eq("gender", 1)
                .orderByDesc("age")
                .last("limit 1,4"));
        employees.forEach(System.out::println);
    }

    /**
     * 条件构造器修改操作
     */
    @Test
    public void testQueryWrapperUpdate() {
        Employee employee = new Employee();
        employee.setLastName("假面骑士");
        employee.setEmail("cls@atguigu.com");
        employee.setGender(1);
        int update = employeeMapper.update(employee, new UpdateWrapper<Employee>()
                .eq("last_name", "Tom")
                .or(employeeQueryWrapper -> employeeQueryWrapper.eq("age", 44))
        );
        System.out.println(update);
    }

    /**
     * 条件构造器删除操作
     */
    @Test
    public void testQueryWrapperDelete() {
        int delete = employeeMapper.delete(new QueryWrapper<Employee>().
                eq("last_name", "假面骑士")
                .eq("age", 45));
        System.out.println(delete);
    }
}