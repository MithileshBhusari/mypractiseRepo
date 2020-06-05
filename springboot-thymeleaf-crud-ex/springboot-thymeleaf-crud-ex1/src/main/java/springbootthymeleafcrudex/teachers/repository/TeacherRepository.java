package com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.repository;

import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher,Long> {
    List<Teacher> findByName(String name);
}
