package com.example.CRUD.Operations.clinical_trial;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RunNotFoundException extends RuntimeException{
    public RunNotFoundException(){
        super("We cannot find the trial you are looking for.");
    }
}
