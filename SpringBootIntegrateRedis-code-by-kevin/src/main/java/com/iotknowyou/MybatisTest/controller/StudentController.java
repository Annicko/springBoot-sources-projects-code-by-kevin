package com.iotknowyou.MybatisTest.controller;

import com.iotknowyou.MybatisTest.entity.Student;
import com.iotknowyou.MybatisTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/getAllStudent")
    public String getAll(Model model){
        model.addAttribute("ALLStudent",studentService.GetAllStudents());
        return "MybatisTest/studentPages";
    }

    @ResponseBody
    @RequestMapping("/addStudent")
    public String addStudent(){
        Student student = new Student();
        student.setAge(23);
        student.setName("LiuRongHua");
        student.setNumber("LN00026");
        studentService.addUser(student);
        return "success";
    }
}
