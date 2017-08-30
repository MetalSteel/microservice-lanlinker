package com.lanlinker.cloud.restful;

import com.lanlinker.cloud.entity.ResultBean;
import com.lanlinker.cloud.entity.ResultStatus;
import com.lanlinker.cloud.entity.Student;
import com.lanlinker.cloud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 学生类RESTful接口
 * Created by MetalSteel on 2017/8/30.
 */
@RestController
public class StudentController {
    /**
     * 注入业务层
     */
    @Autowired
    private StudentService studentService;

    /**
     * 查询所有学生信息
     * @return
     */
    @GetMapping("/findAllStudents")
    public ResultBean<List<Student>> findAllStudents(){
        return new ResultBean<List<Student>>(ResultStatus.SUCCESS,"学生信息查询成功",studentService.findAllStudents());
    }

    /**
     * 根据Id查询学生信息
     * @param id
     * @return
     */
    @GetMapping("/findStudentById/{id}")
    public ResultBean<Student> findStudentById(@PathVariable("id") Integer id){
        int i = 1/0;
        return new ResultBean<Student>(ResultStatus.SUCCESS,"学生信息查询成功",studentService.findStudentById(id));
    }

    /**
     * 添加学生信息
     * @param student
     * @param bindingResult
     * @return
     */
    @PostMapping("/addStudent")
    public ResultBean<Student> addStudent(@Valid @RequestBody Student student, BindingResult bindingResult){
        // 创建返回结果
        ResultBean<Student> resultBean = new ResultBean<>();
        // 数据完整性校验
        if(bindingResult.hasFieldErrors()){
            resultBean.setCode(ResultStatus.ERROR);
            resultBean.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return resultBean;
        }
        // 添加学生信息
        Student addStudent = studentService.addStudent(student);
        if(addStudent!=null){
            resultBean.setCode(ResultStatus.SUCCESS);
            resultBean.setMsg("学生信息添加成功");
            resultBean.setData(addStudent);
        }else {
            resultBean.setCode(ResultStatus.ERROR);
            resultBean.setMsg("学生信息添加失败");
        }

        return resultBean;
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    @PutMapping("/updateStudent")
    public ResultBean<Student> updateStudent(@RequestBody Student student){
        // 创建返回结果
        ResultBean<Student> resultBean = new ResultBean<>();
        // 修改学生信息
        Student updateStudent = studentService.updateStudent(student);
        // 返回
        resultBean.setCode(ResultStatus.SUCCESS);
        resultBean.setMsg("学生信息修改成功");
        resultBean.setData(updateStudent);
        return resultBean;
    }

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    @DeleteMapping("/deleteStudent/{id}")
    public ResultBean<String> deleteStudent(@PathVariable("id") Integer id){
        // 创建返回结果
        ResultBean<String> resultBean = new ResultBean<>();
        // 删除学生信息
        studentService.deleteStudent(id);
        // 填充返回结果
        resultBean.setCode(ResultStatus.SUCCESS);
        resultBean.setMsg("学生信息删除成功");
        resultBean.setData(null);
        return resultBean;
    }

}
