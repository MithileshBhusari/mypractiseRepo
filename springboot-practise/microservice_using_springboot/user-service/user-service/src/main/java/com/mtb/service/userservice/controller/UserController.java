package com.mtb.service.userservice.controller;

import com.mtb.service.userservice.entity.User;
import com.mtb.service.userservice.service.UserService;
import com.mtb.service.userservice.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author MithileshB
 * @created 28/01/2022 - 9:37 PM
 * @project user-service
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside saveUser method of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId){
        log.info("Inside getUserWithDepartment method of UserController");
        return userService.getUserWithDepartment(userId);
    }
}
