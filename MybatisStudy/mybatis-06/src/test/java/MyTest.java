import com.xiao.dao.StudentMapper;
import com.xiao.dao.TeacherMapper;
import com.xiao.pojo.Student;
import com.xiao.pojo.Teacher;
import com.xiao.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author simba@onlying.cn
 * @date 2021/5/17 17:51
 */
public class MyTest {

    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents2();
        students.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getTeacher() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher2(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}