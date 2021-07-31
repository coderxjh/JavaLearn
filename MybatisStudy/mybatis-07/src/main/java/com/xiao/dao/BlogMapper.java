package com.xiao.dao;

import com.xiao.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map<String, String> map);

    List<Blog> queryBlogChoose(Map<String, String> map);

    //更新博客
    int updateBlog(Map<String, String> map);

    //查询1-2-3号记录的博客
    List<Blog> queryBlogForeach(Map<String, Object> map);

    int addBlogs( List<Blog> blogs);
}
