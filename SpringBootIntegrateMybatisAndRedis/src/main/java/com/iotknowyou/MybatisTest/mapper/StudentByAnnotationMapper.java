/*============================================================================================================*/

/* 使用 注解 配置的的方式*/


package com.iotknowyou.MybatisTest.mapper;

import com.iotknowyou.MybatisTest.entity.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface StudentByAnnotationMapper {

    /*获取所有的学生信息*/
    @Select("SELECT * FROM m_student")
    @Results(id = "StudentMap",value = {
            @Result(property = "id",column = "id",jdbcType = JdbcType.INTEGER,id=true),
            @Result(property = "age",column = "age",jdbcType = JdbcType.INTEGER),
            @Result(property = "name",column = "name",jdbcType = JdbcType.VARBINARY),
            @Result(property = "number",column = "number",jdbcType = JdbcType.VARBINARY)
    })
    List<Student> getAll();

    /*通过 id 查询学生的信息*/
    @Select("SELECT * FROM m_student where id = #{id}")
    @ResultMap(value = "StudentMap")
    Student get(Integer id);

    /*添加一个学生信息*/
    @Insert("INSERT INTO m_student (name,age,number) VALUES (#{name},#{age},#{number})")
    void insert(Student student);

    /*修改Student的信息*/
    @Update("UPDATE m_student SET name=#{userName},age = #{age},number = #{number} WHERE id = #{id} ")
    void updata(Student student);

    /* 删除学生 */
    @Delete("DELETE FROM m_student WHERE id = #{id}")
    void delete(Integer id);
}
