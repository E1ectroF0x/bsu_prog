package com.bsu.edu.restapi.controller;

import com.bsu.edu.restapi.entity.Teacher;
import com.bsu.edu.restapi.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping(value = "/all")
    public List<Teacher> getAll() {
        return teacherService.getAllTeachers();
    }

    @GetMapping(value = "/{id}")
    public Teacher getById(@PathVariable Long id) {
        return teacherService.getTeacherById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        teacherService.deleteTeacherById(id);
    }

    @PostMapping
    public void save(@RequestBody Teacher teacher) {
        teacherService.saveTeacher(teacher);
    }

}
