package com.mtb.springcacheex.demo.controller;

import com.mtb.springcacheex.demo.model.Student;
import com.mtb.springcacheex.demo.service.APIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author MithileshB
 * @created 20/11/2021 - 6:43 PM
 * @project demo
 */
@RestController
@RequestMapping("/student")
public class CacheController {

    @Autowired
    private APIService apiService;

    @GetMapping
    public ResponseEntity<Student> fetchStudent(@RequestParam(name="studentId")String studentId) throws InterruptedException{
        return new ResponseEntity<>(apiService.fetchStudent(studentId).get(), HttpStatus.OK);
    }
}
