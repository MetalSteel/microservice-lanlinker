package com.lanlinker.cloud.feign;

import com.lanlinker.cloud.entity.ResultBean;
import com.lanlinker.cloud.entity.ResultStatus;
import com.lanlinker.cloud.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 断路器
 * Created by MetalSteel on 2017/8/30.
 */
@Component
class HystrixStudentFeign implements StudentFeign{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public ResultBean<List<Student>> findAllStudents() {
        return null;
    }

    @Override
    public ResultBean<Student> findStudentById(Integer id) {
        log.info("进入断路器~");
        ResultBean<Student> studentResultBean = new ResultBean<>();
        studentResultBean.setCode(ResultStatus.SUCCESS);
        studentResultBean.setMsg("进入断路器");
        return studentResultBean;
    }

    @Override
    public ResultBean<Student> addStudent(Student student) {
        return null;
    }

    @Override
    public ResultBean<Student> updateStudent(Student student) {
        return null;
    }

    @Override
    public ResultBean<String> deleteStudent(Integer id) {
        return null;
    }

    @Override
    public String upload(MultipartFile file) {
        return null;
    }
}
