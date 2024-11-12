package com.example.CRUD.Operations.clinical_trial;


import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class TrialController {


    @GetMapping("/home")
    String home(){
        return "Hello Welcome to the clinical trial HomePage";
    }

    private final TrialRepository trialRepository;

    public TrialController(TrialRepository trialRepository){
        this.trialRepository = trialRepository;
    }


    @GetMapping("/api/trials")
    List<Clinical_trial> findAll(){
        return trialRepository.findAll();
    }

    @GetMapping("/api/trials/{id}")
    Clinical_trial findById(@PathVariable String id){
        return trialRepository.findById(id).orElseThrow(()-> new RunNotFoundException());
    }


    // post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/api/trials")
    ResponseEntity<Clinical_trial> create(@RequestBody Clinical_trial trial){
        trialRepository.create(trial);
        return new ResponseEntity<>(trial, HttpStatus.CREATED);
    }

    // put
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/api/trials/{id}")
    ResponseEntity<Clinical_trial> update(@RequestBody Clinical_trial trial, @PathVariable String id){
        trialRepository.update(trial, id);
        return new ResponseEntity<>(trial, HttpStatus.NO_CONTENT);
    }


    // delete
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/api/trials/{id}")
    void delete(@PathVariable String id){
        trialRepository.delete(id);
    }
}

