package com.xiao.dao;

import com.xiao.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    Teacher getTeacherById(@Param("id") int id);

    Teacher getTeacher(@Param("id") int id);

    Teacher getTeacher2(@Param("id") int id);
}