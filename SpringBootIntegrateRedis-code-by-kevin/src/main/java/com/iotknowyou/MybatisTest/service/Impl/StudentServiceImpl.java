package com.iotknowyou.MybatisTest.service.Impl;

import com.iotknowyou.MybatisTest.entity.Student;
import com.iotknowyou.MybatisTest.mapper.StudentByAnnotationMapper;
import com.iotknowyou.MybatisTest.mapper.StudentMapper;
import com.iotknowyou.MybatisTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "studentService" )
public class StudentServiceImpl implements StudentService {

    // 使用 XML 的方式配置 mybatis

    @Autowired
    private StudentMapper studentMapper;



    @Override
    public List<Student> GetAllStudents() {
        return studentMapper.getAll();
    }




    // 使用 注解的方式，配置mybatis


    @Autowired
    private StudentByAnnotationMapper studentByAnnotationMapper;


    @Override
    public void addUser(Student student) {
        studentByAnnotationMapper.insert(student);
    }
}
