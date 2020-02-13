package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.DTO.FacultyDTO;
import com.bsu.edu.restapi.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping(value = "/{id}")
    public FacultyDTO getFacultyById(@PathVariable Long id){
        return facultyService.getFacultyById(id);
    }

    @GetMapping(value = "/all")
    public List<FacultyDTO> getAll(){
        return facultyService.getAll();
    }

}
