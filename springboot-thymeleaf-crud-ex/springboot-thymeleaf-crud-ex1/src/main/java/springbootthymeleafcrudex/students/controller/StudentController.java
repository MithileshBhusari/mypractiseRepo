package com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.students.controller;

import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.students.model.Student;
import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("signup")
    public String showSignUpForm(Student student) {
        return "add-student";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addStudent(@Valid Student student, BindingResult result,Model model){
        if(result.hasErrors()){
            return "add-student";
        }
        studentService.save(student);
        return "redirect:list";
    }

    @GetMapping("edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id,Model model){
        Student student=studentService.findById(id);
        model.addAttribute("student",student);
        return "update-student";
    }

    @PostMapping("update/{id}")
    public String updateStudent(@PathVariable("id") long id,@Valid Student student,BindingResult result,Model model){

        if(result.hasErrors()){
            student.setId(id);
            return "update-student";
        }
        studentService.save(student);
        model.addAttribute("students",studentService.findAll());

        return "index";
    }

    @GetMapping("delete/{id}")
    public String deleteStudent(@PathVariable("id") long id,Model model){
        Student student=studentService.findById(id);
        studentService.deleteStudent(student);
        model.addAttribute("students",studentService.findAll());
        return  "index";
    }


}
