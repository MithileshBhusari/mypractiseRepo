package com.mtb.webappproject.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public boolean validateUser(String email, String password) {
        return email.equalsIgnoreCase("mithilesh.bhusari@xxxx.com")
                && password.equalsIgnoreCase("1111");
    }

}
