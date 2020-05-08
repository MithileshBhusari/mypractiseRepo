package com.mtb.webappproject.service;

import com.mtb.webappproject.model.User;
import com.mtb.webappproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsersList(){
        return userRepository.findAll();
    }
    public boolean validateUser(String username, String password) {
        return username.equalsIgnoreCase("mtb")
                && password.equalsIgnoreCase("1111");

    }

}
