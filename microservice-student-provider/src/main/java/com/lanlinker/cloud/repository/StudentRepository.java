package com.lanlinker.cloud.repository;

import com.lanlinker.cloud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 学生类DAO操作
 * Created by MetalSteel on 2017/8/29.
 */
public interface StudentRepository extends JpaRepository<Student,Integer>{

}
