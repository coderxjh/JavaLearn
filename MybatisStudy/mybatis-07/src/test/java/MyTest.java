import com.xiao.dao.BlogMapper;
import com.xiao.pojo.Blog;
import com.xiao.utils.IDUtils;
import com.xiao.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

/**
 * @author simba@onlying.cn
 * @date 2021/5/18 15:09
 */
public class MyTest {

    @Test
    public void addBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        mapper.addBlog(new Blog(IDUtils.getId(), "Spring从入门到精通", "张三", new Date(), 8588));
        mapper.addBlog(new Blog(IDUtils.getId(), "MyBatis从入门到精通", "李四", new Date(), 2888));
        mapper.addBlog(new Blog(IDUtils.getId(), "SpringMVC从入门到精通", "王五", new Date(), 6888));
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIF() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("title", "Spring从入门到精通");
        map.put("author", "张三2");
        List<Blog> blogs = mapper.queryBlogIF(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void updateBlog() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, String> map = new HashMap<>();
        map.put("title", "Spring从入门到精通");
        map.put("author", "张三2");
        mapper.updateBlog(map);
        sqlSession.close();
    }

    @Test
    public void queryBlogForeach() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Map<String, Object> map = new HashMap<>();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        map.put("ids", ids);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
        sqlSession.close();
    }

    @Test
    public void addBlogs() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> list = new ArrayList<>();
        list.add(new Blog(IDUtils.getId(), "Spring从入门到精通", "张三", new Date(), 588));
        list.add(new Blog(IDUtils.getId(), "MyBatis从入门到精通", "李四", new Date(), 888));
        list.add(new Blog(IDUtils.getId(), "SpringMVC从入门到精通", "王五", new Date(), 688));
        mapper.addBlogs(list);
        sqlSession.close();
    }
}