package com.xiao.dao;

import com.xiao.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    Student getStudentBytId(@Param("tid") int id);

    List<Student> getStudents2();

    List<Student> getStudents();
}