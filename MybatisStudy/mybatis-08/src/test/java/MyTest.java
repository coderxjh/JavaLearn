import com.xiao.dao.UserMapper;
import com.xiao.pojo.User;
import com.xiao.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author simba@onlying.cn
 * @date 2021/5/18 16:46
 */
public class MyTest {

    @Test
    public void test(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(2);
        System.out.println(user);
        System.out.println("------------");
//        sqlSession.clearCache();
//        mapper.updateUser(new User(2,"aaa","bbb"));
        User user1 = mapper.queryUserById(2);
        System.out.println(user1);
        sqlSession.close();
    }

    @Test
    public void test2(){
        SqlSession sqlSession1 = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession1.getMapper(UserMapper.class);
        User user = mapper.queryUserById(2);
        System.out.println(user);
        sqlSession1.close();
        System.out.println("--------------");
        UserMapper mapper1 = sqlSession2.getMapper(UserMapper.class);
        User user1 = mapper1.queryUserById(2);
        System.out.println(user1);
        User user2 = mapper1.queryUserById(3);
        System.out.println(user2);
        User user3 = mapper1.queryUserById(3);
        System.out.println(user3);
        sqlSession2.close();
    }
}
