package com.poc.FinancialManager.services;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public boolean validateUser(String userid, String password) {
        // in28minutes, dummy
        return userid.equalsIgnoreCase("USER")
                && password.equalsIgnoreCase("DUMMY");
    }


}
