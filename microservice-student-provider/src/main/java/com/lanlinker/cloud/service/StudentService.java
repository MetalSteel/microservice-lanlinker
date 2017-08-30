package com.lanlinker.cloud.service;

import com.lanlinker.cloud.entity.Student;
import com.lanlinker.cloud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生类业务层操作
 * Created by MetalSteel on 2017/8/29.
 */
@Service
public class StudentService {
    /**
     * 注入持久层操作
     */
    @Autowired
    private StudentRepository studentRepository;

    /**
     * 查询所有的学生
     * @return
     */
    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    /**
     * 根据Id查询学生
     * @param id
     * @return
     */
    public Student findStudentById(Integer id){
        return studentRepository.findOne(id);
    }

    /**
     * 添加学生
     * @param student
     * @return
     */
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    /**
     * 删除学生
     * @param id
     */
    public void deleteStudent(Integer id){
        studentRepository.delete(id);
    }

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }
}
