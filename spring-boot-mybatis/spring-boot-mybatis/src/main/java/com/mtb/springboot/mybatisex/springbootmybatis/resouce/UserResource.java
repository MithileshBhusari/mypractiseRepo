package com.mtb.springboot.mybatisex.springbootmybatis.resouce;

import com.mtb.springboot.mybatisex.springbootmybatis.mappers.UsersMapper;
import com.mtb.springboot.mybatisex.springbootmybatis.model.Users;
import com.mtb.springboot.mybatisex.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource {

    private UsersMapper usersMapper;

    @Autowired
    private UserService userService;

    public UserResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("/getAllUsers")
    public List<Users> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("getUser/{name}")
    public Users getUser(@PathVariable String name) {
        return userService.findUser(name);
    }

    @PostMapping("/addUser")
    private List<Users> addUser(@RequestBody Users user) {
        userService.addUser(user);
        return usersMapper.findAll();
    }

    @DeleteMapping("/{name}")
    private void deleteUser(@PathVariable String name) {
        userService.deleteUser(name);
    }

}
