package com.mtb.springboot.mybatisex.springbootmybatis.service;

import com.mtb.springboot.mybatisex.springbootmybatis.mappers.UsersMapper;
import com.mtb.springboot.mybatisex.springbootmybatis.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UsersMapper usersMapper;

    public void deleteUser(String name) {
        usersMapper.deleteByName(name);
    }

    public void addUser(Users user) {
        usersMapper.insert(user);
    }

    public Users findUser(String name) {
      return  usersMapper.findUser(name);
    }

    public List<Users> findAll() {
        return usersMapper.findAll();
    }
}
