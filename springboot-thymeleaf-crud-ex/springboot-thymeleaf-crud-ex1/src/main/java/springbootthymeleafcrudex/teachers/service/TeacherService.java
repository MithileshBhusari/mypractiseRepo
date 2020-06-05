package com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.service;

import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.model.Teacher;
import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {


    @Autowired
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher findById(long id) {
        return teacherRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Teacher id : "+id));
    }

    public void deleteTeacher(Teacher teacher) {
        teacherRepository.delete(teacher);
    }
}
