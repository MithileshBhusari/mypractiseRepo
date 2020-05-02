package com.mtb.webappproject.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean validateUser(String username, String password) {
        return username.equalsIgnoreCase("mtb")
                && password.equalsIgnoreCase("1111");
    }

}
