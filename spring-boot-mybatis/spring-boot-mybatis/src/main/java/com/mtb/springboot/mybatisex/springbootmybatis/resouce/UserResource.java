package com.mtb.springboot.mybatisex.springbootmybatis.resouce;

import com.mtb.springboot.mybatisex.springbootmybatis.mappers.UsersMapper;
import com.mtb.springboot.mybatisex.springbootmybatis.model.Users;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UserResource  {

    private UsersMapper usersMapper;

    public UserResource(UsersMapper usersMapper) {
        this.usersMapper = usersMapper;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return usersMapper.findAll();
    }
@GetMapping("/addUser")
    private List<Users> addUser(){
        Users users=new Users();
  //      users.setId(3);
        users.setName("Bhushan");
        users.setSalary("3000");

        usersMapper.insert(users);
        return  usersMapper.findAll();
    }

    @DeleteMapping("/{name}")
    private void deleteUser(@RequestMapping name String name){

    }

}
