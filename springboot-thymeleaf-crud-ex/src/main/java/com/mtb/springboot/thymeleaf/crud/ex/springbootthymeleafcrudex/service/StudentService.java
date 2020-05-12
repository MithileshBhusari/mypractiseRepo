package com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.service;

import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.model.Student;
import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

        @Autowired
        private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public Student findById(long id) {
        return studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid Student id : "+id));
    }

    public void deleteStudent(Student student) {
         studentRepository.delete(student);
    }
}
