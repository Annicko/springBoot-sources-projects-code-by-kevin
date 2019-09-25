package com.iotknowyou.MybatisTest.service;

import com.iotknowyou.MybatisTest.entity.Student;

import java.util.List;

public interface StudentService {
    /* 获取所有的学生*/
    List<Student> GetAllStudents();

    /* 使用注解的配置配置的方式，添加一个学生 */
    void addUser(Student student);
}
