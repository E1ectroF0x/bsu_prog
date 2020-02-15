package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.DTO.IOSStudentDTO;
import com.bsu.edu.restapi.DTO.LoginDTO;
import com.bsu.edu.restapi.DTO.StudentDTO;
import com.bsu.edu.restapi.service.IOSStudentService;
import com.bsu.edu.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    IOSStudentService iosStudentService;

    @GetMapping(value = "/all")
    public List<StudentDTO> getAll() {
        return this.studentService.getAllStudents();
    }

    @PostMapping
    public void saveStudent(@RequestBody StudentDTO model) {
        this.studentService.saveStudent(model);
    }

    @PostMapping
    public IOSStudentDTO getStudent(@RequestBody LoginDTO model){
        return this.iosStudentService.getStudent(model);
    }

}
