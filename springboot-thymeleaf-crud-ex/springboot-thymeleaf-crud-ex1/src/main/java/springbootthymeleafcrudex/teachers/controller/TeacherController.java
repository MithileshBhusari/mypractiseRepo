package com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.controller;


import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.students.model.Student;
import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.students.service.StudentService;
import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.model.Teacher;
import com.mtb.springboot.thymeleaf.crud.ex.springbootthymeleafcrudex.teachers.service.TeacherService;
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
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("signup")
    public String showSignUpForm(Teacher teacher) {
        return "add-teacher";
    }

    @GetMapping("list")
    public String showUpdateForm(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "index";
    }

    @PostMapping("add")
    public String addTeacher(@Valid Teacher teacher, BindingResult result, Model model){
        if(result.hasErrors()){
            return "add-teacher";
        }
        teacherService.save(teacher);
        return "redirect:list";
    }

    @GetMapping("teachers/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model){
        Teacher teacher=teacherService.findById(id);
        model.addAttribute("teacher",teacher);
        return "update-teacher";
    }

    @PostMapping("teachers/update/{id}")
    public String updateTeacher(@PathVariable("id") long id,@Valid Teacher teacher,BindingResult result,Model model){

        if(result.hasErrors()){
            teacher.setId(id);
            return "update-teacher";
        }
        teacherService.save(teacher);
        model.addAttribute("teachers",teacherService.findAll());

        return "index";
    }

    @GetMapping("teachers/delete/{id}")
    public String deleteStudent(@PathVariable("id") long id,Model model){
        Teacher teacher=teacherService.findById(id);
        teacherService.deleteTeacher(teacher);
        model.addAttribute("teachers",teacherService.findAll());
        return  "index";
    }

}
