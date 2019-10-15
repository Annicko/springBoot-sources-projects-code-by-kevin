package com.iotknowyou.MybatisTest.service.Impl;

import com.iotknowyou.MybatisTest.entity.Student;
import com.iotknowyou.MybatisTest.mapper.StudentByAnnotationMapper;
import com.iotknowyou.MybatisTest.mapper.StudentMapper;
import com.iotknowyou.MybatisTest.service.StudentService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.xml.bind.ValidationEvent;
import java.util.List;

@MapperScan(basePackages = "com.iotknowyou.MybatisTest.mapper")
@CacheConfig(cacheNames = "student")
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

    // 通过id 查询一个学生
    @Cacheable(key ="#p0")
    @Override
    public Student getOne(Integer id){
        return studentByAnnotationMapper.get(id);
    }

    // 通过 id 修改一个用户的信息
    @CachePut(value = "user" , key = "#p0.id")
    @Override
    public Student updateInfo(Student student){
        studentByAnnotationMapper.updata(student);
        return student;
    }

    @CacheEvict(value = "student" , key = "#p0" ,allEntries = true)
    @Override
    public void deleteStudnet(Integer id){
        studentByAnnotationMapper.delete(id);
    }
}
