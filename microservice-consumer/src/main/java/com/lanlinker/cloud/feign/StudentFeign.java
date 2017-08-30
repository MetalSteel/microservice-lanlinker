package com.lanlinker.cloud.feign;

import com.lanlinker.cloud.entity.ResultBean;
import com.lanlinker.cloud.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 消费Student服务的客户端
 * Created by MetalSteel on 2017/8/30.
 */
@FeignClient(name = "MICROSERVICE-ZUUL",fallback = HystrixStudentFeign.class)
public interface StudentFeign {
    /**
     * 处理/findAllStudents/的GET请求,获取学生列表集合
     * @return
     */
    @GetMapping("/student/findAllStudents")
    ResultBean<List<Student>> findAllStudents();

    /**
     * 处理/findStudentById的GET请求,根据Id获取指定学生信息
     * @param id
     * @return
     */
    @GetMapping("/student/findStudentById/{id}")
    ResultBean<Student> findStudentById(@PathVariable("id")Integer id);

    /**
     * 处理/addStudent的POST请求,添加学生信息
     * @param student
     * @return
     */
    @PostMapping("/student/addStudent")
    ResultBean<Student> addStudent(Student student);

    /**
     * 处理/updateStudent的PUT请求,修改学生信息
     * @param student
     * @return
     */
    @PutMapping("/student/updateStudent")
    ResultBean<Student> updateStudent(Student student);

    /**
     * 处理/deleteStudent的DELETE请求,删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping("/student/deleteStudent/{id}")
    ResultBean<String> deleteStudent(@PathVariable("id")Integer id);

    @PostMapping("/zuul/file/upload")
    String upload(@RequestParam(value = "file",required = true)MultipartFile file);
}
