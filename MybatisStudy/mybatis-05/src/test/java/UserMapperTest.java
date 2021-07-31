import com.xiao.dao.UserMapper;
import com.xiao.pojo.User;
import com.xiao.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author simba@onlying.cn
 * @date 2021/5/17 15:54
 */
public class UserMapperTest {

    @Test
    public void test() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//        List<User> users = mapper.getUsers();
//        users.forEach(System.out::println);
        User user = mapper.getUserById(2);
        System.out.println(user);
//        mapper.addUser(new User(8,"爱迪","123431"));
//        mapper.updateUser(new User(8, "阿斯特拉", "2134342"));
//        mapper.deleteUser(3);
//        sqlSession.commit();
        sqlSession.close();
    }
}
