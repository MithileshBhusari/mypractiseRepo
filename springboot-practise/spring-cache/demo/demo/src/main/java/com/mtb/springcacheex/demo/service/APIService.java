package com.mtb.springcacheex.demo.service;

import com.mtb.springcacheex.demo.model.Address;
import com.mtb.springcacheex.demo.model.Major;
import com.mtb.springcacheex.demo.model.Student;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author MithileshB
 * @created 20/11/2021 - 6:46 PM
 * @project demo
 */
@Service
public class APIService {

    @Cacheable(value = "student-cache",key="'StudentCache'+#studentId")
    public Optional<Student> fetchStudent(String studentId) throws InterruptedException{
        Thread.sleep(4000);
        return Arrays.asList(new Student("123","Mithilesh","Bhusari","10",
                new Address("180","Police Nagar","Nagpur","MH","440011"), Major.MATHS))
                .stream().filter(t->t.getStudentId().equals(studentId)).findFirst();

    }
}
