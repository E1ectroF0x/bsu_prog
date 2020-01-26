package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.DTO.TeacherDTO;
import com.bsu.edu.restapi.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/teachers")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/all")
    public List<TeacherDTO> getAll() {
        log.debug("Getting all teachers");
        return teacherService.getAllTeachers();
    }

    @DeleteMapping
    public void deleteById(@RequestParam String name, @RequestParam String secondName, @RequestParam String lastName) {
        teacherService.deleteTeacherByFIO(name, secondName, lastName);
    }

    @PostMapping
    public void save(@RequestBody TeacherDTO model) {
        teacherService.saveTeacher(model);
    }

}
