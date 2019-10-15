package com.iotknowyou.MybatisTest.entity;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String name;

    private Integer age;

    /* 学号*/
    private String number;

    public Student() {
    }

    public Student(String name, Integer age, String number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", number='" + number + '\'' +
                '}';
    }
}
