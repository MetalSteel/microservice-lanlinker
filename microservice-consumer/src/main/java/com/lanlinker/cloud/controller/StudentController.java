package com.lanlinker.cloud.controller;

import com.lanlinker.cloud.entity.ResultBean;
import com.lanlinker.cloud.entity.ResultStatus;
import com.lanlinker.cloud.entity.Student;
import com.lanlinker.cloud.feign.StudentFeign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 学生信息控制器
 * Created by MetalSteel on 2017/8/30.
 */
@RestController
public class StudentController {
    /**
     * 日志
     */
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    /**
     * 注入Feign客户端
     */
    @Autowired
    private StudentFeign studentFeign;

    /**
     * 查询所有学生信息
     * @return
     */
    @GetMapping("/findAllStudents")
    public List<Student> findAllStudent(){
        return studentFeign.findAllStudents().getData();
    }

    /**
     * 根据Id查询学生
     * @param id
     * @return
     */
    @GetMapping("/findStudentById/{id}")
    public Student findStudentById(@PathVariable("id") Integer id){
        log.info("根据Id查询学生信息{}",id);
        return studentFeign.findStudentById(id).getData();
    }

    /**
     * 添加学生信息
     * @param student
     * @return
     */
    @PostMapping("/addStudent")
    public Student addStudent(Student student){
        log.info("添加学生信息{}",student);
        return studentFeign.addStudent(student).getData();
    }

    /**
     * 更新学生信息
     * @param student
     * @return
     */
    @PutMapping("/updateStudent")
    public Student updateStudent(Student student){
        log.info("更新学生信息{}",student);
        return studentFeign.updateStudent(student).getData();
    }

    /**
     * 根据Id删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping("/deleteStudent/{id}")
    public ResultBean<String> deleteStudent(@PathVariable("id") Integer id){
        log.info("删除学生信息{}",id);
        return studentFeign.deleteStudent(id);
    }

    @PostMapping("/uploadImg")
    public ResultBean<String> uploadImg(@RequestParam(value = "file",required = true) MultipartFile file){
        String uploadMsg = studentFeign.upload(file);
        ResultBean<String> rs = new ResultBean<>();
        rs.setCode(ResultStatus.SUCCESS);
        log.info("文件上传信息{}",file);
        rs.setMsg("文件上传成功=>"+uploadMsg);
        return rs;
    }

}
