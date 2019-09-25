
/*============================================================================================================*/

/* 使用XML 配置的的方式*/


package com.iotknowyou.MybatisTest.mapper;

import com.iotknowyou.MybatisTest.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {


    /*获取所有的学生*/
    List<Student> getAll();
}

