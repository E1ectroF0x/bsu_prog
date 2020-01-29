package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.entity.Subject;
import com.bsu.edu.restapi.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @GetMapping(value = "/{id}")
    public Subject getById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @GetMapping(value = "/all")
    public List<Subject> getAll(){
        return  subjectService.getAllSubjects();
    }

    @PostMapping
    public void set(@RequestBody Subject subject){
        subjectService.saveSubject(subject);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        subjectService.deleteSubjectById(id);
    }
}
