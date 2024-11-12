package com.example.CRUD.Operations;

import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {
    public String getWelcomeMessage(){
        return "Welcome to the Spring boot Application!!";
    }
}
