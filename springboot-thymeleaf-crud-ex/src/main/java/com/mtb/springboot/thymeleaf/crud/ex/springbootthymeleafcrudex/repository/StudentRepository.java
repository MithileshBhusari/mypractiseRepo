package com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.repository;

import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByName(String name);
}
