package com.iotknowyou.MybatisTest.controller;

import com.iotknowyou.MybatisTest.entity.Student;
import com.iotknowyou.MybatisTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
/*

    在实际的开发中，会使用 Redis 做缓存。我们如何使用 Springboot集成 Mybatis 使用 Redis作为项目的缓存

    主要是学习下面的注解使用：
        *
        @Cacheable  : 主要针对方法配置，能够根据方法的请求参数对其结果进行缓存。
            value  缓存的名称，在spring配置文件中定义，必须指定至少一个， 使用 ---> @Cacheable(value = "mycache")
            key    缓存的key，可以为null，如果指定，就要按照 SqEL表达式编写，如果不指定，那么默认按照方法的所有参数进行组合。
                   使用  ---> @Cacheable(value = "mycache" , key = "#userName")
        condition  缓存的条件，可以为空，使用SqEL表达式编写，返回true 或者false ，只有true才会进行缓存。
                   使用  ---> @Cacheable(value="testcache" ,condition = "#userName.length()>3")

        **
        @CachePut   : 主要针对方法配置，能根据方法的返回值对其结果进行缓存。
                    和 @cacheable 不同的是，它每一次都会触发真实方法的调用，
                    其他地方写的是根据方法的请求对其结果进行缓存，实际上是对方法返回值进行缓存。
        value  缓存的名称，在spring配置文件中定义，必须指定至少一个， 使用 ---> @CachePut(value = "mycache")
            key    缓存的key，可以为null，如果指定，就要按照 SqEL表达式编写，如果不指定，那么默认按照方法的所有参数进行组合。
                   使用  ---> @CachePut(value = "mycache" , key = "#userName")
        condition  缓存的条件，可以为空，使用SqEL表达式编写，返回true 或者false ，只有true才会进行缓存。
                   使用  ---> @CachePut(value="testcache" ,condition = "#userName.length()>3")

        ***
        @CachEvict  : 主要针对方法配置，能够根据一定的条件对缓存进行清空，

            value  缓存的名称，在spring配置文件中定义，必须指定至少一个， 使用 ---> @CachEvict(value = "mycache")
            key    缓存的key，可以为null，如果指定，就要按照 SqEL表达式编写，如果不指定，那么默认按照方法的所有参数进行组合。
                   使用  ---> @CachEvict(value = "mycache" , key = "#userName")
        condition  缓存的条件，可以为空，使用SqEL表达式编写，返回true 或者false ，只有true才会进行缓存。
                   使用  ---> @CachEvict(value="testcache" ,condition = "#userName.length()>3")
       allEntries  是否清空所缓存内容，默认为false，如果指定为 true，则方法调用后将立即清空所有缓存
                   使用  ---> @CachEvict(value = "mycache" , allEntries = true)
  beforeInvocation 是否在方法执行前就清空，默认是false，如果指定为true，则在方法还没有执行的时候就清空缓存，
                    默认的情况下，如果方法抛出了异常，则不会清空缓存。
        ****
        @CacheConfig  ： 允许通过 @CacheConfig(cacheName = "user")这种方式设置缓存名字
    */



    @Autowired
    private StudentService studentService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate<String, Serializable> redisCacheTemplate;

    @RequestMapping("/getAllStudent")
    public String getAll(Model model){
        model.addAttribute("ALLStudent",studentService.GetAllStudents());
        return "MybatisTest/studentPages";
    }

    @RequestMapping("/addStudent")
    public String addStudent(){
        Student student = new Student();
        student.setAge(23);
        student.setName("LiuRongHua");
        student.setNumber("LN00026");
        studentService.addUser(student);
        return "forward:/student/getAllStudent";
    }

    @RequestMapping(value = "getStudnetById/{id}",method = RequestMethod.GET)
    public ModelAndView getStudentById(@PathVariable("id") int id){
        Student student = studentService.getOne(id);
        ModelAndView modelAndView = new ModelAndView("MybatisTest/studentPages");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        modelAndView.addObject("ALLStudent",studentList);
        return modelAndView;
    }

    @RequestMapping(value = "deleteStudnetById/{id}",method = RequestMethod.GET)
    public ModelAndView deleteStudnetById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("MybatisTest/studentPages");
        //通过id删除
        studentService.deleteStudnet(id);
        modelAndView.addObject("ALLStudent",studentService.GetAllStudents());
        return modelAndView;
    }

    @RequestMapping(value = "updateStudnetById/{id}",method = RequestMethod.GET)
    public ModelAndView updateStudnetById(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("MybatisTest/studentPages");
        Student student = new Student("LiuRonghua",23,"new User");
        //更新用户
        studentService.updateInfo(student);
        modelAndView.addObject("ALLStudent",studentService.GetAllStudents());
        return modelAndView;
    }
}
